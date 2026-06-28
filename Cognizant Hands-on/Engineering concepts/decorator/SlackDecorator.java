package decorator;

public class SlackDecorator implements Notifier {
    Notifier wrapped;

    public SlackDecorator(Notifier notifier) {
        this.wrapped = notifier;
    }

    public void send(String message) {
        wrapped.send(message);
        System.out.println("Slack Notification: " + message);
    }
}
