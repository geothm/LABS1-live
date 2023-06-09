package ro.irian.pizzaapp.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pizza_table")
public class Pizza {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "name_col", nullable = false, length = 100)
    private String name;
    private int diameter;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;

    public Pizza() {
    }

    public Pizza(String name, int diameter, List<Ingredient> ingredients) {
        this.name = name;
        this.diameter = diameter;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
