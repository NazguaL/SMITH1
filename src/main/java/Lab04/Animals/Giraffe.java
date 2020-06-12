package Lab04.Animals;


public class Giraffe extends Hoofed {
    private AnimalName animalName;

    public Giraffe(String name, int age) {
        super(name, age);
        this.animalName = AnimalName.Giraffe;
    }
}