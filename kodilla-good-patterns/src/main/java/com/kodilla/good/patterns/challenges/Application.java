package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
    User user = new User("Jan Kowalski", "jan.kowalski@example.com");
    Product product = new Product("Gra planszowa", 99.99);

    ProductOrderService productOrderService = new ProductOrderService(
            new EmailInformationService(),
            new ProductOrderServiceImpl(),
            new OrderRepositoryImpl()
    );

            OrderDto orderResult = productOrderService.process(user, product);
            System.out.println("Czy zamówienie zostało zrealizowane? " + orderResult.isOrdered());

}
}