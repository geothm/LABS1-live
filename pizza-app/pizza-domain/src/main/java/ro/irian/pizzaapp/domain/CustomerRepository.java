package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager em;

    public void save (Customer customer) {
        em.persist(customer);
    }

    public Customer getById(long id){
        return em.find(Customer.class, id);
    }
}
