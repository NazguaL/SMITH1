package Lab04;



import Lab04.Cages.Cage;

import java.util.ArrayList;
import java.util.List;

public class Lab04Zoo {
    public List<Cage> cages = new ArrayList<>();
    public int getCountOfAnimals (){
        int count = 0;
        for (Cage cage : cages){
            count += cage.getAnimalsQuantity();
        }
        return count;
    }
    public void addCage(Cage cage){
        cages.add(cage);
    }
}
