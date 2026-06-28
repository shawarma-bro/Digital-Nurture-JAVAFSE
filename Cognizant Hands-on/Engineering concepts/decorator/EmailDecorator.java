package decorator;

public class EmailDecorator implements Notifier {
    Notifier wrapped;

    public EmailDecorator(Notifier notifier) {
        this.wrapped = notifier;
    }

    public void send(String message) {
        wrapped.send(message);
        System.out.println("Email Notification: " + message);
    }
}
