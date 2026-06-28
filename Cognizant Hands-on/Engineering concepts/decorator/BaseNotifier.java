package decorator;

public class BaseNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Base Notification: " + message);
    }
}
