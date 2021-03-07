package pl.edu.wszib.store.services;

import pl.edu.wszib.store.model.Order;

public interface IOrderService {
    void saveOrder(Order order);
    Order getOrderById(int id);
}
