package ro.irian.pizzaapp;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.irian.pizzaapp.domain.PizzaOrder;
import ro.irian.pizzaapp.domain.PizzaOrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaOrderService {

    private final PizzaOrderRepository pizzaOrderRepository;
    private final PizzaCustomerService pizzaCustomerService;
    private final ItalianPizzaService italianPizzaService;

    private long firstOrderId;

    public PizzaOrderService(PizzaOrderRepository pizzaOrderRepository,
                             PizzaCustomerService pizzaCustomerService,
                             ItalianPizzaService italianPizzaService) {
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.pizzaCustomerService = pizzaCustomerService;
        this.italianPizzaService = italianPizzaService;
    }

    @Transactional
    public void saveFirstOrder(){
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizzaList(italianPizzaService.getAllPizzas());
        pizzaOrder.setCustomer(pizzaCustomerService.saveFirstCustomer());
        pizzaOrder.setPlacedAt(LocalDateTime.now());
        pizzaOrder.setPrice(100);

        pizzaOrderRepository.save(pizzaOrder);

        firstOrderId = pizzaOrder.getId();
    }

    public List<PizzaOrder> getAllPizzaOrders(){
        List<PizzaOrder> pizzaOrders = new ArrayList<>();
        pizzaOrders.add(pizzaOrderRepository.getById(firstOrderId));

        return pizzaOrders;
    }
    
}
