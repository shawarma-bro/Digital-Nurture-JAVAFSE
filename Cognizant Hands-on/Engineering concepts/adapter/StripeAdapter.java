package adapter;

public class StripeAdapter implements PaymentGateway {
    String cardNumber;

    public StripeAdapter(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Stripe with card: " + cardNumber);
    }
}
