package food2Door;

public class GlutenFreeShop implements Supplier {
    @Override
    public boolean process(String product, int quantity){
        System.out.println("GlutenFreeShop: Sprawdzanie dostępności dla " + product);
        return quantity > 0;
    }
}
