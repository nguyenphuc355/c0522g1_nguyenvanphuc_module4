package furama_managemrnt.serrvice.customerService;

import furama_managemrnt.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    void update(Customer customer);

    void delete(int id);

//    void remove(int id);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByName(Pageable pageable, String name, String phoneNumber, String address);


}
