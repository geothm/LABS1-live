package ro.irian.labs.pizzaapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.pizzaapp.PizzaOrderService;
import ro.irian.pizzaapp.domain.PizzaOrder;

import java.util.List;

@RestController
@RequestMapping("orders")
public class PizzaOrderController {

    private static final Logger LOG = LoggerFactory.getLogger(PizzaOrderController.class);

    private final PizzaOrderService pizzaOrderService;

    public PizzaOrderController(PizzaOrderService pizzaOrderService) {
        this.pizzaOrderService = pizzaOrderService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<PizzaOrder> getPizzaOrders() {
        LOG.debug("Getting all orders...");
        return  pizzaOrderService.getAllPizzaOrders();
    }

}
