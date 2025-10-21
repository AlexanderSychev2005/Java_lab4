package org.zoo.cages;

import org.zoo.animals.Animal;
import org.zoo.exceptions.AnimalNotFoundException;
import org.zoo.exceptions.CageFullException;

import java.util.ArrayList;
import java.util.List;

// Base class "Cage" - T extends Animal - generic type for animals in the cage
public class Cage <T extends Animal> {

    private final int maxCapacity;
    private final List<T> animals;

    public Cage(int maxCapacity) {
        if (maxCapacity <=0 ) {
            throw new IllegalArgumentException("Max capacity must be greater than zero.");
        }
        this.maxCapacity = maxCapacity;
        this.animals = new ArrayList<>();
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCount() {
        return animals.size();
    }

    public void addAnimal(T animal) {
        if (animals.size() >= maxCapacity) {
            throw new CageFullException("Cage " + this.getClass().getSimpleName() + " is full. Cannot add more animals.");
        }
        animals.add(animal);
        System.out.println("Cage " + this.getClass().getSimpleName() + " added animal " + animal);
    }

    public void removeAnimal(T animal) {
        boolean removed = animals.remove(animal);
        if (!removed) {
            throw new AnimalNotFoundException("Cage " + this.getClass().getSimpleName() + " does not contain animal " + animal);
        } else {
            System.out.println("Cage " + this.getClass().getSimpleName() + " removed animal " + animal);
        }
    }

    public void listAnimals() {
        System.out.println("Cage " + this.getClass().getSimpleName() + " contains the following animals:");
        if (animals.isEmpty()) {
            System.out.println("- No animals in the cage.");
            return;
        }
        for (T animal : animals) {
            System.out.println("- " + animal);
        }
    }

}
