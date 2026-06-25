public class AnimalFactory{
    public Animal createAnimal(String type){
        if (type.equals("Dog")){
            return new Dog();
        }
        else if (type.equals("Cat")){
            return new Cat();
        }
        else{
            System.out.println("Animal Not Found");
            return null;
        }
    }
}