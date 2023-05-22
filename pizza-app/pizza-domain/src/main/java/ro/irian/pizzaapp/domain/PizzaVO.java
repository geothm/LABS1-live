package ro.irian.pizzaapp.domain;

public class PizzaVO {

    private final long id;
    private final String name;
    private final Long ingredientsNo;

    public PizzaVO(long id, String name, Long ingredientsNo) {
        this.id = id;
        this.name = name;
        this.ingredientsNo = ingredientsNo;
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
