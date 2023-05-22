package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.irian.pizzaapp.domain.CustomerType;
import ro.irian.pizzaapp.domain.Customer;
import ro.irian.pizzaapp.domain.CustomerRepository;
import ro.irian.pizzaapp.domain.CustomerVO;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer saveFirstCustomer(){
        Customer customer = new Customer();
        customer.setName("Veronica");
        customer.setCustomerType(CustomerType.newCustomer);
        customerRepository.save(customer);
        return customer;
    }

    public List<CustomerVO> getAllCustomerVOs(){
        return customerRepository.getAllCustomerVos();
    }
    
}
