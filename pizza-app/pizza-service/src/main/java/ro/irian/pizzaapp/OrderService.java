package ro.irian.pizzaapp;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.irian.pizzaapp.domain.Order;
import ro.irian.pizzaapp.domain.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ItalianPizzaService italianPizzaService;

    private long firstOrderId;

    public OrderService(OrderRepository orderRepository,
                        CustomerService customerService,
                        ItalianPizzaService italianPizzaService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.italianPizzaService = italianPizzaService;
    }

    @Transactional
    public void saveFirstOrder(){
        Order order = new Order();
        order.setPizzaList(italianPizzaService.getAllPizzas());
        order.setCustomer(customerService.saveFirstCustomer());
        order.setPlacedAt(LocalDateTime.now());
        order.setPrice(100);

        orderRepository.save(order);

        firstOrderId = order.getId();
    }

    public List<Order> getAllPizzaOrders(){
        List<Order> orders = new ArrayList<>();
        orders.add(orderRepository.getById(firstOrderId));

        return orders;
    }
    
}
