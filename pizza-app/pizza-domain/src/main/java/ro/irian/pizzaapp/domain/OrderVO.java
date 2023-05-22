package ro.irian.pizzaapp.domain;

import java.time.LocalDateTime;

public class OrderVO {

    private final long id;
    private final LocalDateTime orderDate;
    private final String customerName;
    private final Long pizzaNo;
    private final double value;
    private final CurrencyCode currencyCode;

    public OrderVO(long id, LocalDateTime orderDate, String customerName, Long pizzaNo, double value, CurrencyCode currencyCode) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.pizzaNo = pizzaNo;
        this.value = value;
        this.currencyCode = currencyCode;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Long getPizzaNo() {
        return pizzaNo;
    }

    public double getValue() {
        return value;
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }
}
