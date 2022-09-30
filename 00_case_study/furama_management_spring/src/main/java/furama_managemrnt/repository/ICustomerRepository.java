package furama_managemrnt.repository;

import furama_managemrnt.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findById(int id);


    @Query(value = "select * from Customer where name like %:name% AND phone_number LIKE %:phoneNumber% AND address like %:address%" ,nativeQuery = true)
    Page<Customer> searchName(@Param("name") String name,@Param("phoneNumber") String phoneNumber,@Param("address") String address, Pageable pageable);

}
