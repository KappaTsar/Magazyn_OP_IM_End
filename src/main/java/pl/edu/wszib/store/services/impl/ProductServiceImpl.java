package pl.edu.wszib.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.store.dao.IProductDAO;
import pl.edu.wszib.store.model.Product;
import pl.edu.wszib.store.services.IProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductDAO productDAO;

    @Override
    public Product getProductById(int id) {
        return this.productDAO.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        Product productFromDB = this.productDAO.getProductById(product.getId());
        productFromDB.setName(product.getName());
        productFromDB.setQuan(product.getQuan());
        productFromDB.setPrice(product.getPrice());

        this.productDAO.updateProduct(productFromDB);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }
}
