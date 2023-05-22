package ro.irian.labs.pizzaapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ro.irian.pizzaapp.IPizzaService;
import ro.irian.pizzaapp.ItalianPizzaService;
import ro.irian.pizzaapp.domain.Pizza;
import ro.irian.pizzaapp.domain.PizzaVO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    private static final Logger LOG = LoggerFactory.getLogger(PizzaController.class);

    private final List<IPizzaService> pizzaServices;
    private final ItalianPizzaService italianPizzaService;

    public PizzaController(List<IPizzaService> pizzaServices, ItalianPizzaService italianPizzaService) {
        this.pizzaServices = pizzaServices;
        this.italianPizzaService = italianPizzaService;
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
}
