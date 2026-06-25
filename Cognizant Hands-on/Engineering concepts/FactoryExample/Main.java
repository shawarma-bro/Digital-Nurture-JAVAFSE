public class Main {
    public static void main (String[] args){
        AnimalFactory factory = new AnimalFactory();
        Animal animal = factory.createAnimal("Cat");
        animal.sound();
    }
}