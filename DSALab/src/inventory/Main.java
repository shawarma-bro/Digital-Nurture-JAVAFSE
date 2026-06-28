package inventory;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product(1, "Laptop", 10, 999.99));
        manager.addProduct(new Product(2, "Mouse", 50, 25.99));
        manager.addProduct(new Product(3, "Keyboard", 30, 49.99));

        manager.displayAll();

        System.out.println();
        manager.updateProduct(2, 40, 22.99);
        manager.displayAll();

        System.out.println();
        manager.deleteProduct(3);
        manager.displayAll();

        System.out.println();
        manager.addProduct(new Product(1, "Duplicate Laptop", 5, 899.99));
    }
}
