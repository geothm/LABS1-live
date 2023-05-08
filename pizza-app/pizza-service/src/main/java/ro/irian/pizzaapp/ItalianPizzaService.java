package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItalianPizzaService implements IPizzaService{

    @Override
    public List<String> getAllPizzas(){
        List<String> pizzas = new ArrayList<>();

        pizzas.add(getPizzaProsciutto());
        pizzas.add(getPizzaSalami());

        return pizzas;
    }

    private String getPizzaSalami() {
        return "Salami";
    }

    private String getPizzaProsciutto() {
        return "Prosciutto";
    }
}
