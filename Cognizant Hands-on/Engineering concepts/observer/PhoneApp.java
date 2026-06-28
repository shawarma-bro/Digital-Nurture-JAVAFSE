package observer;

public class PhoneApp implements Observer {
    String appName;

    public PhoneApp(String name) {
        this.appName = name;
    }

    public void update(String stockName, double price) {
        System.out.println("[" + appName + "] Alert: " + stockName + " is now $" + price);
    }
}
