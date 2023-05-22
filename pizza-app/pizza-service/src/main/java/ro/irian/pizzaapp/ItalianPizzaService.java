package ro.irian.pizzaapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.irian.pizzaapp.domain.Ingredient;
import ro.irian.pizzaapp.domain.Pizza;
import ro.irian.pizzaapp.domain.PizzaRepository;
import ro.irian.pizzaapp.domain.PizzaVO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ItalianPizzaService implements IPizzaService{

    private final PizzaRepository pizzaRepository;

    private long salamiPizzaId;
    private long prosciutoPizzaId;

    public ItalianPizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Transactional
    public void savePizzas(){
        saveSalamiPizza();
        saveProsciuttoPizza();
    }

    public Pizza getPizzaByName(String name) {
        return pizzaRepository.getByName(name);
    }

    public List<Pizza> getPizzasByIngredientName(String ingredientName) {
        return pizzaRepository.getByIngredientName(ingredientName);
    }

    public List<PizzaVO> getAllPizzaVOs(){
        return pizzaRepository.getAllPizzaVOs();
    }

    private void saveProsciuttoPizza() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Dough", 70));
        ingredients.add(new Ingredient("Tomato Sauce", 50));
        ingredients.add(new Ingredient("Prosciutto", 15));
        Pizza pizza = new Pizza("Prosciutto", 30, ingredients);

        pizzaRepository.save(pizza);

        prosciutoPizzaId = pizza.getId();
    }

    private void saveSalamiPizza() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Dough", 70));
        ingredients.add(new Ingredient("Tomato Sauce", 50));
        ingredients.add(new Ingredient("Salami", 15));
        Pizza pizza = new Pizza("Salami", 30, ingredients);

        pizzaRepository.save(pizza);

        salamiPizzaId = pizza.getId();
    }

    @Override
    public Set<Pizza> getAllPizzas(){
        Set<Pizza> pizzas = new HashSet<>();

        pizzas.add(pizzaRepository.getByIdQuery(salamiPizzaId));
        pizzas.add(pizzaRepository.getByIdQuery(prosciutoPizzaId));

        return pizzas;
    }
}
