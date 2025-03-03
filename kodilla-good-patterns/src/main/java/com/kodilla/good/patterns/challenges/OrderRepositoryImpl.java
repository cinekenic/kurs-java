package com.kodilla.good.patterns.challenges;

public class OrderRepositoryImpl extends OrderRepository {
        @Override
    public void createOrder(User user, Product product){
            System.out.println("Zamówienie zapisane w bazie danych: " + product.getProductName() + " dla użytkownika " + user.getName());
        }
}
