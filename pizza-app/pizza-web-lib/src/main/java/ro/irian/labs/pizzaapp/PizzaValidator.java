package ro.irian.labs.pizzaapp;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ro.irian.pizzaapp.ItalianPizzaService;
import ro.irian.pizzaapp.PizzaDTO;

@Component
public class PizzaValidator implements Validator {

    private final ItalianPizzaService italianPizzaService;

    public PizzaValidator(ItalianPizzaService italianPizzaService) {
        this.italianPizzaService = italianPizzaService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PizzaDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PizzaDTO pizzaDTO = (PizzaDTO) target;

        if(italianPizzaService.getPizzaByName(pizzaDTO.getName()) != null) {
            errors.rejectValue("name", "pizza_exists");
        }
    }
}
