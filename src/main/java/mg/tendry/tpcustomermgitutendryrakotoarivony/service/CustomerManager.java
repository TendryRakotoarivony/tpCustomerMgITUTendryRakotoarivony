package mg.tendry.tpcustomermgitutendryrakotoarivony.service;

import java.util.List;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.persistence.Query;
import mg.tendry.tpcustomermgitutendryrakotoarivony.entity.Customer;
/**
 * Façade pour gérer les Customers.
 * @author Tendry Arivony
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Customer> getAllCustomers() {
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }

    @Transactional
    public Customer update(Customer customer) {
       return em.merge(customer);
    }

    @Transactional
    public void persist(Customer customer) {
       em.persist(customer);
    }
}
