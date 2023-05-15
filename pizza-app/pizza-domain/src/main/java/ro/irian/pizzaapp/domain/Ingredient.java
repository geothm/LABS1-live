package ro.irian.pizzaapp.domain;

public class Ingredient {

    private String name;
    private double quantityGrams;

    public Ingredient(String name, double quantityGrams) {
        this.name = name;
        this.quantityGrams = quantityGrams;
    }

    public String getName() {
        return name;
    }

    public double getQuantityGrams() {
        return quantityGrams;
    }
}
