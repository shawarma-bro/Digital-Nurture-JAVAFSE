package dependencyinjection;

public class CustomerService {
    CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(String name) {
        repository.save(name);
    }

    public void getCustomer(int id) {
        String customer = repository.findById(id);
        System.out.println("Found: " + customer);
    }
}
