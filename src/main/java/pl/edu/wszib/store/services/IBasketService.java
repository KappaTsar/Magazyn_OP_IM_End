package pl.edu.wszib.store.services;

public interface IBasketService {
    double calculateTotal();
    void addProductByIdToBasket(int id);
}
