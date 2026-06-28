package observer;

public class EmailAlert implements Observer {
    String email;

    public EmailAlert(String email) {
        this.email = email;
    }

    public void update(String stockName, double price) {
        System.out.println("[Email to " + email + "] " + stockName + " price updated to $" + price);
    }
}
