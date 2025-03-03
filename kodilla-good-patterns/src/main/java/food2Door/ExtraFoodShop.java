package food2Door;

public class ExtraFoodShop implements Supplier {
    @Override
    public boolean process(String product, int quantity){
        System.out.println("ExtraFoodShop: Realizacja zamówienia na " + quantity + " szt. produktu: " + product);
        return quantity  <= 50;
    }
}
