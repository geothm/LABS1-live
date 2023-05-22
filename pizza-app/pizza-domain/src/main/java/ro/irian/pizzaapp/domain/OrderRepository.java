package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    public List<OrderVO> getAllOrderVOs(){
        return em.createQuery("select new ro.irian.pizzaapp.domain.OrderVO(" +
                        "ord.id, " +
                        "ord.placedAt," +
                        "c.name," +
                        "count(pizzas)," +
                        "ord.price.value," +
                        "ord.price.currencyCode" +
                        ") from Order ord " +
                        " join ord.customer c "+
                        "join ord.pizzaList pizzas group by ord, c ")
                .getResultList();
    }
}
