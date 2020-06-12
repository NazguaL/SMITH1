package Lab04.Animals;


public class Lion extends Mammal {
    private  AnimalName animalName;

    public Lion (String name, int age) {
        super(name, age);
        this.animalName = AnimalName.Lion;
    }
}