package pl.edu.wszib.store.services;

import pl.edu.wszib.store.model.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(int id);
    void updateProduct(Product product);
    List<Product> getAllProducts();
}
