package proxy;

public class Main {
    public static void main(String[] args) {
        Image img = new ProxyImage("photo.jpg");

        System.out.println("First call:");
        img.display();

        System.out.println("\nSecond call:");
        img.display();
    }
}
