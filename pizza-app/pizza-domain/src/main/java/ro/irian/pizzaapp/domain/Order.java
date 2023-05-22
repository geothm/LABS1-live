package ro.irian.pizzaapp.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "pizza_order")
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    private LocalDateTime placedAt;

    @Embedded
    private CurrencyValue price;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "order_pizza_join_table")
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

    public CurrencyValue getPrice() {
        return price;
    }

    public void setPrice(CurrencyValue price) {
        this.price = price;
    }

    public Set<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(Set<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
