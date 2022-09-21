package product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import product_management.model.Product;

;import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    Product findById(int id);

    List<Product> findAllByOrderByNameDesc();


    @Query(value = "select * from Product where name like  %:name% ", nativeQuery = true)
    List<Product> searchByName(@Param("name") String name);
}
