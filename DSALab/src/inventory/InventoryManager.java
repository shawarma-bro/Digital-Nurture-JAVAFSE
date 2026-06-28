package inventory;

import java.util.HashMap;

public class InventoryManager {
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) {
        if (inventory.containsKey(p.productId)) {
            System.out.println("Product with ID " + p.productId + " already exists.");
        } else {
            inventory.put(p.productId, p);
            System.out.println("Product added: " + p.productName);
        }
    }

    public void updateProduct(int id, int newQuantity, double newPrice) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = newQuantity;
            p.price = newPrice;
            System.out.println("Product updated: " + p.productName);
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    public void deleteProduct(int id) {
        if (inventory.containsKey(id)) {
            System.out.println("Product deleted: " + inventory.get(id).productName);
            inventory.remove(id);
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    public void displayAll() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("--- Inventory ---");
            for (Product p : inventory.values()) {
                p.display();
            }
        }
    }
}
