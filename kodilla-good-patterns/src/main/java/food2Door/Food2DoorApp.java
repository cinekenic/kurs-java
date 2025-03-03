package food2Door;

public class Food2DoorApp {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        orderProcessor.registerSupplier("ExtraFoodShop", new ExtraFoodShop());
        orderProcessor.registerSupplier("HealthyShop", new HealthyShop());
        orderProcessor.registerSupplier("GlutenFreeShop", new GlutenFreeShop());

        orderProcessor.processOrder("ExtraFoodShop", "Jabłka", 30);
        orderProcessor.processOrder("HealthyShop", "Bio Marchewka", 10);
        orderProcessor.processOrder("GlutenFreeShop", "Chleb bezglutenowy", 5);
        orderProcessor.processOrder("HealthyShop", "Zwykła Marchewka", 10);
    }
}
