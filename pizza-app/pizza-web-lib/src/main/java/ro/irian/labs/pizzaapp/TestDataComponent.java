package ro.irian.labs.pizzaapp;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.irian.pizzaapp.ItalianPizzaService;
import ro.irian.pizzaapp.OrderService;

import javax.annotation.PostConstruct;

@Component
public class TestDataComponent {
    private final ItalianPizzaService italianPizzaService;
    private final OrderService orderService;

    public TestDataComponent(ItalianPizzaService italianPizzaService, OrderService orderService) {
        this.italianPizzaService = italianPizzaService;
        this.orderService = orderService;
    }

    @PostConstruct
    public void init(){
        italianPizzaService.savePizzas();
        orderService.saveFirstOrder();
    }
}
