package shoppping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shoppping_cart.model.Product;

@Repository
public interface IProductRepository  extends JpaRepository<Product,Integer> {

}
