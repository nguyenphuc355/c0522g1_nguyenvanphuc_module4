package abc.serrvice.impl;

import abc.model.Customer;
import org.springframework.stereotype.Service;
import abc.serrvice.ICustomerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private static List<Customer> customers;
    private static long autoIncreaseId = 1;
    static {
        customers = Arrays.asList(
                new Customer(autoIncreaseId++, "T", "t@codegym.vn", "Da Nang"),
                new Customer(autoIncreaseId++, "Nhat", "nhat@codegym.vn", "Quang Tri"),
                new Customer(autoIncreaseId++, "Trang", "trang@codegym.vn", "Ha Noi"),
                new Customer(autoIncreaseId++, "Nguyen Binh Son", "son@codegym.vn", "Sai Gon"),
                new Customer(autoIncreaseId++, "Dang Xuan Hoa", "hoa.dang@codegym.vn", "Da Nang")
        );
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public Customer findOne(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Customer customer) {

    }

    @Override
    public void delete(List<Customer> customers) {

    }

    @Override
    public void deleteAll() {

    }
}
