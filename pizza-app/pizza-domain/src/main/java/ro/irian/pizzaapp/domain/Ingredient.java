package ro.irian.pizzaapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ingredient_table")
public class Ingredient {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private double quantityGrams;

    public Ingredient() {
    }

    public Ingredient(String name, double quantityGrams) {
        this.name = name;
        this.quantityGrams = quantityGrams;
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

    public void setQuantityGrams(double quantityGrams) {
        this.quantityGrams = quantityGrams;
    }

    public String getName() {
        return name;
    }

    public double getQuantityGrams() {
        return quantityGrams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
