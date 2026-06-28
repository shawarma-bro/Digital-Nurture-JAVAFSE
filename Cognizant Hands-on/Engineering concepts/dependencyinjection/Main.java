package dependencyinjection;

public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.addCustomer("Alice");
        service.addCustomer("Bob");

        service.getCustomer(1);
        service.getCustomer(2);
    }
}
