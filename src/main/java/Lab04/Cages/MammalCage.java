package Lab04.Cages;

import Lab04.Animals.Animal;

public class MammalCage<T extends Animal> extends Cage<T> {
    public MammalCage (int capacity) {
        super(capacity);
    }
}