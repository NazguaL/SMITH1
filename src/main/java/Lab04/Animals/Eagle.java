package Lab04.Animals;


public class Eagle extends Bird {
    private AnimalName animalName;
    public Eagle (String name, int age) {
        super(name, age);
        this.animalName = AnimalName.Eagle;
    }
}