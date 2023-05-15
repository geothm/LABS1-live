package ro.irian.pizzaapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Pizza {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int diameter;
    @OneToMany
    private List<Ingredient> ingredients;

    public Pizza() {
    }

    public Pizza(String name, int diameter, List<Ingredient> ingredients) {
        this.name = name;
        this.diameter = diameter;
        this.ingredients = ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setIngredients(List<Ingredient> ingredients) {
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
