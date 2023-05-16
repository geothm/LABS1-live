package ro.irian.pizzaapp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private PizzaCustomer pizzaCustomer;

    private LocalDateTime placedAt;

    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Pizza> pizzaList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(Set<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public PizzaCustomer getCustomer() {
        return pizzaCustomer;
    }

    public void setCustomer(PizzaCustomer pizzaCustomer) {
        this.pizzaCustomer = pizzaCustomer;
    }
}
