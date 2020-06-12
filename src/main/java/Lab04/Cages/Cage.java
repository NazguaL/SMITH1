package Lab04.Cages;

import Lab04.Animals.Animal;
import Lab04.Exeptions.AnimalIsMissingExeption;
import Lab04.Exeptions.NoFreePlacesExeption;

import java.util.ArrayList;
import java.util.List;

public abstract class Cage<T extends Animal> {
    private int capacity;
    private List<T> animals = new ArrayList<T>();

    public Cage(int capacity) {
        this.capacity = capacity;
    }

    public void PutIn(T animal) throws NoFreePlacesExeption {
        if (animals.size() == capacity)
            throw new NoFreePlacesExeption("There are no free places in cage!");
        else
            animals.add(animal);
    }

    public void DropOut(T animal) throws AnimalIsMissingExeption {
        if (animals.indexOf(animal) == -1)
            throw new AnimalIsMissingExeption("Animal is missing!");
        else
            animals.remove(animal);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAnimalsQuantity() {
        return animals.size();
    }
}