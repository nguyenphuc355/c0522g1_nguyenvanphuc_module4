package furama_managemrnt.repository;

import furama_managemrnt.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findById(int id);

    @Query(value = "select * from Employee where name like %:name% AND phone_number LIKE %:phoneNumber% AND address like %:address%" ,nativeQuery = true)
    Page<Employee> searchName(String name, String phoneNumber, String address, Pageable pageable);

}
