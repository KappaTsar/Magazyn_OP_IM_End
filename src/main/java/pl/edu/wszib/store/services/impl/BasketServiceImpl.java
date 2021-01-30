package pl.edu.wszib.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.store.dao.IProductDAO;
import pl.edu.wszib.store.model.Product;
import pl.edu.wszib.store.services.IBasketService;
import pl.edu.wszib.store.session.SessionObject;

import javax.annotation.Resource;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IProductDAO productDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public double calculateTotal() {
        double sum = 0;
        for (Product product : this.sessionObject.getBasket()) {
            sum = sum + product.getPrice() * product.getQuan();
        }
        return sum;
    }

    @Override
    public void addProductByIdToBasket(int id) {
        Product product = this.productDAO.getProductById(id);
        for(Product productFromBasket : this.sessionObject.getBasket()) {
            if(productFromBasket.getId() == product.getId()) {
                productFromBasket.setQuan(productFromBasket.getQuan() + 1);
                return;
            }
        }

        product.setQuan(1);
        this.sessionObject.getBasket().add(product);
    }
}
