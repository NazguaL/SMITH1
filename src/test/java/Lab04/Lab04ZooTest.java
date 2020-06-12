package Lab04;

import Lab04.Animals.Animal;
import Lab04.Animals.Giraffe;
import Lab04.Animals.Lion;
import Lab04.Cages.Cage;
import Lab04.Cages.LionCage;
import Lab04.Exeptions.NoFreePlacesExeption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


class Lab04ZooTest {

    Lab04Zoo zoo;

    public Cage cageL = new LionCage(3);
    public Cage cageH = new LionCage(3);

    Animal l1 = new Lion("Muffasa", 20);
    Animal l2 = new Lion("Simba", 3);
    Animal l3 = new Lion("Kiara", 3);
    Animal g1 = new Giraffe("Goo", 7);

    @Test
    void addCage() {
        zoo = new Lab04Zoo();
        zoo.addCage(cageL);
        zoo.addCage(cageH);

        assertEquals(2, zoo.cages.size());
    }

    @Test
    void getCountOfAnimals() throws NoFreePlacesExeption {
        zoo = new Lab04Zoo();

        cageL.PutIn(l1);
        cageL.PutIn(l2);
        cageL.PutIn(l3);

        cageH.PutIn(g1);

        zoo.addCage(cageL);
        zoo.addCage(cageH);

        assertEquals(4, zoo.getCountOfAnimals());
    }


}