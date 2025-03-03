package food2Door;

import java.util.HashMap;
import java.util.Map;

public class OrderProcessor {
    private final Map<String, Supplier> suppliers = new HashMap<>();

    public void registerSupplier(String name, Supplier supplier){
        suppliers.put(name, supplier);
    }

    public void processOrder(String supplierName, String product, int quantity){
        Supplier supplier = suppliers.get(supplierName);
        if(supplier == null){
            boolean success = supplier.process(product, quantity);
            System.out.println("Status zamówienia: " + (success ? "Zrealizowane" : "Niepowodzenie"));
        } else {
            System.out.println("Dostawca " + supplierName + " nie jest zarejestrowany!");
        }
    }
}
