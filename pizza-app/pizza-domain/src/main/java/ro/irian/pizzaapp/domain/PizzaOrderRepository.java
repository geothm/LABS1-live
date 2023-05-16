package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PizzaOrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (PizzaOrder pizzaOrder) {
        em.persist(pizzaOrder);
    }

    public PizzaOrder getById(long id){
        return em.find(PizzaOrder.class, id);
    }
}
