package strategy;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(299.99);

        cart.setPaymentStrategy(new PayPalPayment("buyer@gmail.com"));
        cart.checkout(149.00);
    }
}
