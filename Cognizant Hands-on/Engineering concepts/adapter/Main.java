package adapter;

public class Main {
    public static void main(String[] args) {
        PaymentGateway paypal = new PayPalAdapter("user@gmail.com");
        paypal.pay(150.00);

        PaymentGateway stripe = new StripeAdapter("4111-1111-1111-1111");
        stripe.pay(200.00);
    }
}
