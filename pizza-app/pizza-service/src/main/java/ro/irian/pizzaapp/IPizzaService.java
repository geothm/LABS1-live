package ro.irian.pizzaapp;

import ro.irian.pizzaapp.domain.Pizza;

import java.util.Set;

public interface IPizzaService {

    Set<Pizza> getAllPizzas();
}
