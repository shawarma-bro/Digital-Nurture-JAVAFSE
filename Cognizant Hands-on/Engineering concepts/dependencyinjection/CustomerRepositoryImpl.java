package dependencyinjection;

public class CustomerRepositoryImpl implements CustomerRepository {
    public void save(String customerName) {
        System.out.println("Customer saved to database: " + customerName);
    }

    public String findById(int id) {
        return "Customer #" + id + " - John Doe";
    }
}
