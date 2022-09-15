package product_management.repository.impl;

import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iphone 13", 27000000, "new 100%"));
        products.put(2, new Product(2, "iphone 12", 25000000, "new 100%"));
        products.put(3, new Product(3, "iphone 11", 20000000, "new 100%"));
        products.put(4, new Product(4, "samsung not20", 17000000, "new 100%"));
        products.put(5, new Product(5, "samsung note20ultra", 23000000, "new 100%"));
        products.put(6, new Product(6, "oppo renoZ", 16000000, "new 100%"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<Integer, Product> item : products.entrySet()) {
            if (item.getValue().getName().contains(name)) {
                productList.add(item.getValue());
            }
        }
        return productList;
    }
}
