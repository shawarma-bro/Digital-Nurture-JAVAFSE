package decorator;

public class Main {
    public static void main(String[] args) {
        Notifier notifier = new BaseNotifier();
        notifier = new EmailDecorator(notifier);
        notifier = new SMSDecorator(notifier);
        notifier = new SlackDecorator(notifier);

        notifier.send("Server is down!");
    }
}
