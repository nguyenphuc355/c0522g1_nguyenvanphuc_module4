package furama_managemrnt.repository.customerRepository;

import furama_managemrnt.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);

//    List<Customer> findByIsDelete();

    @Modifying
    @Query(value = "update  customer set is_delete = 1 where id = :keyWord", nativeQuery = true)
    void deleteCustomer(@Param("keyWord") int id);

    @Query(value = "select * from Customer where name like %:name% AND phone_number LIKE %:phoneNumber% AND address like %:address% AND is_delete=0", nativeQuery = true)
    Page<Customer> searchName(@Param("name") String name, @Param("phoneNumber") String phoneNumber, @Param("address") String address, Pageable pageable);

}
