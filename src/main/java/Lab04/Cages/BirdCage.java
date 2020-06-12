package Lab04.Cages;


import Lab04.Animals.Animal;

public class BirdCage<T extends Animal> extends Cage<T>{
    public BirdCage(int capacity) {
        super(capacity);
    }
}
