package Lab04.Animals;


public class Zebra extends Hoofed {
    private AnimalName animalName;
    public Zebra(String name, int age) {
        super(name, age);
        this.animalName = AnimalName.Zebra;
    }
}