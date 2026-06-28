package search;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Camera", "Electronics"),
            new Product(2, "Headphones", "Electronics"),
            new Product(3, "Jacket", "Clothing"),
            new Product(4, "Laptop", "Electronics"),
            new Product(5, "Shoes", "Clothing")
        };

        System.out.println("--- Linear Search ---");
        int index = SearchOperations.linearSearch(products, "Jacket");
        if (index != -1) {
            System.out.println("Product found at index " + index + ":");
            products[index].display();
        } else {
            System.out.println("Product not found.");
        }

        System.out.println();
        System.out.println("--- Binary Search (array must be sorted by name) ---");
        int index2 = SearchOperations.binarySearch(products, "Laptop");
        if (index2 != -1) {
            System.out.println("Product found at index " + index2 + ":");
            products[index2].display();
        } else {
            System.out.println("Product not found.");
        }

        System.out.println();
        System.out.println("--- Searching for non-existing product ---");
        int index3 = SearchOperations.linearSearch(products, "Watch");
        if (index3 != -1) {
            products[index3].display();
        } else {
            System.out.println("Product 'Watch' not found.");
        }
    }
}
