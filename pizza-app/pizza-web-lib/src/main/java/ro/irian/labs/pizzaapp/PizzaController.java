package ro.irian.labs.pizzaapp;

import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ro.irian.pizzaapp.IPizzaService;
import ro.irian.pizzaapp.ItalianPizzaService;
import ro.irian.pizzaapp.PizzaDTO;
import ro.irian.pizzaapp.domain.Pizza;
import ro.irian.pizzaapp.domain.PizzaVO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    private static final Logger LOG = LoggerFactory.getLogger(PizzaController.class);

    private final List<IPizzaService> pizzaServices;
    private final ItalianPizzaService italianPizzaService;
    private final PizzaValidator pizzaValidator;

    public PizzaController(List<IPizzaService> pizzaServices, ItalianPizzaService italianPizzaService, PizzaValidator pizzaValidator) {
        this.pizzaServices = pizzaServices;
        this.italianPizzaService = italianPizzaService;
        this.pizzaValidator = pizzaValidator;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Pizza> getPizzas() {
        LOG.debug("Getting all pizzas...");
        return  getAllPizzas();
    }

    @GetMapping(value = "/vo/all", produces = "application/json")
    public List<PizzaVO> getPizzaVOs() {

        return  italianPizzaService.getAllPizzaVOs();
    }

    @GetMapping(value = "/ingredient/{ingredientName}", produces = "application/json")
    public List<Pizza> getPizzasByIngredientName(@PathVariable String ingredientName) {
        return italianPizzaService.getPizzasByIngredientName(ingredientName);
    }

    @GetMapping(value = "/one", produces = "application/json")
    public Pizza getPizzaByName(@RequestParam String name) {
        return italianPizzaService.getPizzaByName(name);
    }

    private List<Pizza> getAllPizzas() {
        List<Pizza> allPizzas = new ArrayList<>();
        pizzaServices.forEach(iPizzaService -> allPizzas.addAll(iPizzaService.getAllPizzas()));
        return allPizzas;
    }

    @PostMapping
    public ResponseEntity savePizza(@Valid @RequestBody PizzaDTO pizzaDTO, BindingResult result){
        pizzaValidator.validate(pizzaDTO, result);
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getAllErrors().forEach(error -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getCode();
                errors.put(fieldName, errorMessage);
            });
            return ResponseEntity.badRequest().body(errors);
        }
        italianPizzaService.savePizzaDTO(pizzaDTO);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
