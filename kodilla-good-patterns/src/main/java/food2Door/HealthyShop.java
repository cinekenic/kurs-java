package food2Door;

public class HealthyShop implements Supplier {
    @Override
    public boolean process(String product, int quantity) {
        System.out.println("HealthyShop: Zamówienie w toku dla: " + product + " (ilość: " + quantity + ")");
        return product.startsWith("Bio"); // Akceptują tylko produkty ekologiczne
    }
}
