package org.zoo;

import org.zoo.cages.Cage;
import org.zoo.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Cage<? extends Animal>> cages = new ArrayList<>(); // Generic list of cages for any type of Animal, ? is a wildcard

    public void addNewCage(Cage<? extends Animal> cage) {
        cages.add(cage);
        System.out.println("Cage " + cage.getClass().getSimpleName() + " added to the zoo.");
    }

    public int getCountOfAnimals() {
        int total = 0;
        for (Cage<? extends Animal> cage : cages) {
            total += cage.getCount();
        }
        return total;
    }
}
