package ro.irian.pizzaapp.domain;

import java.util.List;

public class Pizza {
    private String name;
    private int diameter;
    private List<Ingredient> ingredients;

    public Pizza(String name, int diameter, List<Ingredient> ingredients) {
        this.name = name;
        this.diameter = diameter;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public int getDiameter() {
        return diameter;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
