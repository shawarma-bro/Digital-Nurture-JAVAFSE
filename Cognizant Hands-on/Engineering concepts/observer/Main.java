package observer;

public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        PhoneApp app = new PhoneApp("StockTracker App");
        EmailAlert alert = new EmailAlert("user@gmail.com");

        market.addObserver(app);
        market.addObserver(alert);

        market.setPrice("AAPL", 175.50);
        market.setPrice("GOOGL", 2800.00);
    }
}
