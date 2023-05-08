package ro.irian.labs.pizzaapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pizzas")
public class PizzaController {

    @GetMapping(value = "/all", produces = "application/json")
    public String getPizzas() {
        return "Pizza Menu:";
    }
}
