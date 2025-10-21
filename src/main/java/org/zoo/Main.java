package org.zoo;

import org.zoo.animals.mammals.*;
import org.zoo.animals.birds.*;
import org.zoo.cages.*;
import org.zoo.exceptions.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Zoo Management System!");

        Zoo myZoo = new Zoo();

        LionCage lionCage = new LionCage(2);
        UngulateCage ungulateCage = new UngulateCage(2);
        BirdCage birdCage = new BirdCage(1);

        myZoo.addNewCage(lionCage);
        myZoo.addNewCage(ungulateCage);
        myZoo.addNewCage(birdCage);

        // Adding animals
        Lion lion1 = new Lion("Simba");
        Lion lion2 = new Lion("Nala");
        lionCage.addAnimal(lion1);
        lionCage.addAnimal(lion2);

        ungulateCage.addAnimal(new Zebra("Marty"));
        ungulateCage.addAnimal(new Giraffe("Melman"));

        birdCage.addAnimal(new Eagle("Mighty"));

        lionCage.listAnimals();
        ungulateCage.listAnimals();
        birdCage.listAnimals();

        System.out.println("Total animals in the zoo: " + myZoo.getCountOfAnimals());

        // Testing exception handling CageFullException
        System.out.println("\nTesting CageFullException:");
        try {
            birdCage.addAnimal(new Eagle("Sky"));
        } catch (CageFullException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Testing exception handling AnimalNotFoundException
        System.out.println("\nTesting AnimalNotFoundException:");
        try {
            Lion scar = new Lion("Scar");
            lionCage.removeAnimal(scar);
        } catch (AnimalNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        // Testing successful removing an animal
        System.out.println("\nRemoving an existing animal:");
        lionCage.removeAnimal(lion1);

        System.out.println("Total animals in the zoo after removing: " + myZoo.getCountOfAnimals());


    }
}
