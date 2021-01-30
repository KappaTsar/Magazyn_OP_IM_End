package pl.edu.wszib.store.dao;

import java.util.List;
import pl.edu.wszib.store.model.Product;

public interface IProductDAO {
    Product getProductById(int id);
    void updateProduct(Product product);
    List<Product> getAllProducts();
}
