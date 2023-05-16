package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PizzaCustomerRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (PizzaCustomer pizzaCustomer) {
        em.persist(pizzaCustomer);
    }

    public PizzaCustomer getById(long id){
        return em.find(PizzaCustomer.class, id);
    }
}
