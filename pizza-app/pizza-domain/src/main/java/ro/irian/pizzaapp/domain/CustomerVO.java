package ro.irian.pizzaapp.domain;

public class CustomerVO {

    private final long id;
    private final String name;

    public CustomerVO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
