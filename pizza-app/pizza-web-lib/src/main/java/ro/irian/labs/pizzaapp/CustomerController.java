package ro.irian.labs.pizzaapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.pizzaapp.CustomerService;
import ro.irian.pizzaapp.OrderService;
import ro.irian.pizzaapp.domain.CustomerVO;
import ro.irian.pizzaapp.domain.Order;
import ro.irian.pizzaapp.domain.OrderVO;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/vo/all", produces = "application/json")
    public List<CustomerVO> getCustomerVos() {
        return  customerService.getAllCustomerVOs();
    }

}
