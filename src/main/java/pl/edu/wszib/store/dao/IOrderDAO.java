package pl.edu.wszib.store.dao;

import pl.edu.wszib.store.model.Order;

public interface IOrderDAO {
    void saveOrder(Order order);
    Order getOrderById(int id);
}
