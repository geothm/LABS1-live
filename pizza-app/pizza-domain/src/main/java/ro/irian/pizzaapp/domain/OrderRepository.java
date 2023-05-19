package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (Order order) {
        em.persist(order);
    }

    public Order getById(long id){
        return em.find(Order.class, id);
    }
}
