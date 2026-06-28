package employee;

public class EmployeeManager {
    Employee[] employees;
    int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee added: " + e.name);
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    public void searchEmployee(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found:");
                employees[i].display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void deleteEmployee(int id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee with ID " + id + " not found.");
        } else {
            System.out.println("Employee deleted: " + employees[index].name);
            for (int i = index; i < count - 1; i++) {
                employees[i] = employees[i + 1];
            }
            employees[count - 1] = null;
            count--;
        }
    }

    public void traverseAll() {
        if (count == 0) {
            System.out.println("No employees found.");
        } else {
            System.out.println("--- All Employees ---");
            for (int i = 0; i < count; i++) {
                employees[i].display();
            }
        }
    }
}
