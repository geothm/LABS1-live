package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AmericanPizzaService implements IPizzaService{

    @Override
    public List<String> getAllPizzas(){
        List<String> pizzas = new ArrayList<>();

        pizzas.add(getPizzaPepperoni());

        return pizzas;
    }

    private String getPizzaPepperoni() {
        return "Pepperoni";
    }

}
