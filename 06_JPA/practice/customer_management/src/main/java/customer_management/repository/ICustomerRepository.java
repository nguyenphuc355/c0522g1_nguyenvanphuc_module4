package customer_management.repository;

import customer_management.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);

    void update(Customer customer);
}
