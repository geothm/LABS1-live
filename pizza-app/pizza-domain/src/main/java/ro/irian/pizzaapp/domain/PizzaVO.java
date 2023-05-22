package ro.irian.pizzaapp.domain;

public class PizzaVO {

    private final long id;
    private final String name;
    private  Long ingredientsNo;

    public PizzaVO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getIngredientsNo() {
        return ingredientsNo;
    }
}
