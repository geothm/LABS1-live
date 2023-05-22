package ro.irian.pizzaapp;

import javax.validation.constraints.NotNull;

public class PizzaDTO {

    @NotNull
    private String name;
    private int diameter;

    public PizzaDTO(String name, int diameter) {
        this.name = name;
        this.diameter = diameter;
    }

    public PizzaDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }
}
