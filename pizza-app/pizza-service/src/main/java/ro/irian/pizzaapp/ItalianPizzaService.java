package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;
import ro.irian.pizzaapp.domain.Ingredient;
import ro.irian.pizzaapp.domain.Pizza;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItalianPizzaService implements IPizzaService{

    @Override
    public List<Pizza> getAllPizzas(){
        List<Pizza> pizzas = new ArrayList<>();

        pizzas.add(getPizzaProsciutto());
        pizzas.add(getPizzaSalami());

        return pizzas;
    }

    private Pizza getPizzaSalami() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Dough", 70));
        ingredients.add(new Ingredient("Tomato Sauce", 50));
        ingredients.add(new Ingredient("Salami", 15));
        return new Pizza("Salami", 30, ingredients);
    }

    private Pizza getPizzaProsciutto() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Dough", 70));
        ingredients.add(new Ingredient("Tomato Sauce", 50));
        ingredients.add(new Ingredient("Prosciutto", 15));
        return new Pizza("Prosciutto", 30, ingredients);
    }
}
