package ro.irian.pizzaapp.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @SuppressWarnings("unchecked")
    public Pizza getByIdQuery(long id){
         List<Pizza> list = em.createQuery("select pizza from Pizza pizza " +
                 "where pizza.id = :id ")
                 .setParameter("id", id)
                 .getResultList();
         if (!list.isEmpty()) {
             return list.get(0);
         }
         else {
             return null;
         }
    }

    @SuppressWarnings("unchecked")
    public Pizza getByName(String name){
        List<Pizza> list = em.createQuery("select pizza from Pizza pizza " +
                        "where pizza.name = :name ")
                .setParameter("name", name)
                .getResultList();
        if (!list.isEmpty()) {
            return list.get(0);
        }
        else {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Pizza> getByIngredientName(String ingredientName){
       return em.createQuery("select pizza from Pizza pizza " +
                        " join pizza.ingredients i " +
                        "where i.name = :ingredientName ")
                .setParameter("ingredientName", ingredientName)
                .getResultList();

    }

    @SuppressWarnings("unchecked")
    public List<PizzaVO> getAllPizzaVOs(){
        return em.createQuery("select new ro.irian.pizzaapp.domain.PizzaVO(" +
                "pizza.id, " +
                "pizza.name)" +
                " from Pizza pizza " +
                " ")
                .getResultList();
    }
}
