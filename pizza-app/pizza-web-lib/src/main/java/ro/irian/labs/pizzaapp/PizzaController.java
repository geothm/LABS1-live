package ro.irian.labs.pizzaapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.pizzaapp.IPizzaService;
import ro.irian.pizzaapp.domain.Pizza;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    private static final Logger LOG = LoggerFactory.getLogger(PizzaController.class);

    private final List<IPizzaService> pizzaServices;

    public PizzaController(List<IPizzaService> pizzaServices) {
        this.pizzaServices = pizzaServices;
    }


    @GetMapping(value = "/all", produces = "application/json")
    public List<Pizza> getPizzas() {
        LOG.debug("Getting all pizzas...");
        return  getAllPizzas();
    }

    private List<Pizza> getAllPizzas() {
        List<Pizza> allPizzas = new ArrayList<>();
        pizzaServices.forEach(iPizzaService -> allPizzas.addAll(iPizzaService.getAllPizzas()));
        return allPizzas;
    }
}
