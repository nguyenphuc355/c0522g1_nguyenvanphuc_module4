package product_management.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.IProductRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

//    private static final Map<Integer, Product> products;
//
//    static {
//        products = new HashMap<>();
//        products.put(1, new Product(1, "iphone 13", 27000000, "new 100%"));
//        products.put(2, new Product(2, "iphone 12", 25000000, "new 100%"));
//        products.put(3, new Product(3, "iphone 11", 20000000, "new 100%"));
//        products.put(4, new Product(4, "samsung not20", 17000000, "new 100%"));
//        products.put(5, new Product(5, "samsung note20ultra", 23000000, "new 100%"));
//        products.put(6, new Product(6, "oppo renoZ", 16000000, "new 100%"));
//    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;


    }

    @Override
    public void save(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }


    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.id = : id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product product) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("SELECT c FROM Product AS c WHERE c.id = :id", Product.class);
        query.setParameter("id", id);
        Product product = query.getSingleResult();

        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("select p from Product as p where p.name like :name", Product.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }


}
