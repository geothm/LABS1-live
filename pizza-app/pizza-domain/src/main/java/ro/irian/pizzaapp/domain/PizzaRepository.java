package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PizzaRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (Pizza pizza) {
        em.persist(pizza);
    }

    public Pizza getById(long id){
        return em.find(Pizza.class, id);
    }
}
