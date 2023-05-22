package ro.irian.pizzaapp.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class CurrencyValue {

    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode;
    @Column(name = "value_col")
    private double value;

    public CurrencyValue(CurrencyCode currencyCode, double value) {
        this.currencyCode = currencyCode;
        this.value = value;
    }

    public CurrencyValue() {
    }

    public CurrencyCode getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
