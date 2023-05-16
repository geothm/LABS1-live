package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;
import ro.irian.pizzaapp.domain.Ingredient;
import ro.irian.pizzaapp.domain.Pizza;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AmericanPizzaService implements IPizzaService{

    @Override
    public Set<Pizza> getAllPizzas(){
        Set<Pizza> pizzas = new HashSet<>();

        pizzas.add(getPizzaPepperoni());

        return pizzas;
    }

    private Pizza getPizzaPepperoni() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Dough", 70));
        ingredients.add(new Ingredient("Tomato Sauce", 50));
        ingredients.add(new Ingredient("Pepperoni", 15));
        return new Pizza("Pepperoni", 30, ingredients);
    }

}
