package decorator;

public class SMSDecorator implements Notifier {
    Notifier wrapped;

    public SMSDecorator(Notifier notifier) {
        this.wrapped = notifier;
    }

    public void send(String message) {
        wrapped.send(message);
        System.out.println("SMS Notification: " + message);
    }
}
