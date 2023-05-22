package ro.irian.labs.pizzaapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.pizzaapp.OrderService;
import ro.irian.pizzaapp.domain.Order;
import ro.irian.pizzaapp.domain.OrderVO;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Order> getPizzaOrders() {
        LOG.debug("Getting all orders...");
        return  orderService.getAllPizzaOrders();
    }

    @GetMapping(value = "/vo/all", produces = "application/json")
    public List<OrderVO> getOrderVos() {
        return  orderService.getAllOrderVOs();
    }

}
