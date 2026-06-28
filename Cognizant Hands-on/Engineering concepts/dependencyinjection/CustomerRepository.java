package dependencyinjection;

public interface CustomerRepository {
    void save(String customerName);
    String findById(int id);
}
