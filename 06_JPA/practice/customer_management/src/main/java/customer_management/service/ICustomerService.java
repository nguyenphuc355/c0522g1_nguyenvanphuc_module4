package customer_management.service;

import customer_management.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void remove(int id);
    void update(Customer customer);
}
