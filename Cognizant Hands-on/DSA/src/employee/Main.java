package employee;

public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);

        manager.addEmployee(new Employee(1, "Alice", "Manager", 85000));
        manager.addEmployee(new Employee(2, "Bob", "Developer", 70000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 65000));
        manager.addEmployee(new Employee(4, "Diana", "Tester", 60000));

        System.out.println();
        manager.traverseAll();

        System.out.println();
        manager.searchEmployee(2);

        System.out.println();
        manager.searchEmployee(99);

        System.out.println();
        manager.deleteEmployee(3);
        manager.traverseAll();
    }
}
