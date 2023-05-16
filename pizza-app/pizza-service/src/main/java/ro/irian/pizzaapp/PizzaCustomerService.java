package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.irian.pizzaapp.domain.CustomerType;
import ro.irian.pizzaapp.domain.PizzaCustomer;
import ro.irian.pizzaapp.domain.PizzaCustomerRepository;

@Service
public class PizzaCustomerService {

    private final PizzaCustomerRepository pizzaCustomerRepository;

    public PizzaCustomerService(PizzaCustomerRepository pizzaCustomerRepository) {
        this.pizzaCustomerRepository = pizzaCustomerRepository;
    }

    @Transactional
    public PizzaCustomer saveFirstCustomer(){
        PizzaCustomer pizzaCustomer = new PizzaCustomer();
        pizzaCustomer.setName("Veronica");
        pizzaCustomer.setCustomerType(CustomerType.newCustomer);
        pizzaCustomerRepository.save(pizzaCustomer);
        return pizzaCustomer;
    }
    
}
