package com.kodilla.good.patterns.challenges;

public class ProductOrderServiceImpl implements  OrderService {
    @Override
    public boolean order(User user, Product product){
        System.out.println("Zamówienie na produkt " + product.getProductName() + " zostało zrealizowane dla użytkownika " + user.getName());
        return true;
    }
}
