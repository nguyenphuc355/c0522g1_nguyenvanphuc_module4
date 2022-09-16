package customer_management.repository.impl;

import customer_management.model.Customer;
import customer_management.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository

public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer as c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer as c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }
}
