package ro.irian.labs.pizzaapp;

import org.springframework.stereotype.Service;
import ro.irian.pizzaapp.ItalianPizzaService;
import ro.irian.pizzaapp.PizzaOrderService;

import javax.annotation.PostConstruct;

@Service
public class TestDataComponent {
    private final ItalianPizzaService italianPizzaService;
    private final PizzaOrderService pizzaOrderService;

    public TestDataComponent(ItalianPizzaService italianPizzaService, PizzaOrderService pizzaOrderService) {
        this.italianPizzaService = italianPizzaService;
        this.pizzaOrderService = pizzaOrderService;
    }

    @PostConstruct
    public void init(){
        italianPizzaService.savePizzas();
        pizzaOrderService.saveFirstOrder();
    }
}
