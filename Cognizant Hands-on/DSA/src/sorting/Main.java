package sorting;

public class Main {
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order(101, "Alice", 250.00),
            new Order(102, "Bob", 75.50),
            new Order(103, "Charlie", 500.00),
            new Order(104, "Diana", 120.75),
            new Order(105, "Eve", 30.00)
        };

        Order[] orders2 = {
            new Order(101, "Alice", 250.00),
            new Order(102, "Bob", 75.50),
            new Order(103, "Charlie", 500.00),
            new Order(104, "Diana", 120.75),
            new Order(105, "Eve", 30.00)
        };

        System.out.println("--- Bubble Sort by Total Price ---");
        SortingOperations.bubbleSort(orders1);
        SortingOperations.display(orders1);

        System.out.println();
        System.out.println("--- Quick Sort by Total Price ---");
        SortingOperations.quickSort(orders2, 0, orders2.length - 1);
        SortingOperations.display(orders2);
    }
}
