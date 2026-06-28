package adapter;

public class PayPalAdapter implements PaymentGateway {
    String paypalEmail;

    public PayPalAdapter(String email) {
        this.paypalEmail = email;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account: " + paypalEmail);
    }
}
