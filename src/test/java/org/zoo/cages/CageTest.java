package org.zoo.cages;

import org.zoo.Zoo;
import org.zoo.animals.mammals.Lion;
import org.zoo.animals.mammals.Zebra;
import org.zoo.exceptions.CageFullException;
import org.zoo.exceptions.AnimalNotFoundException;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CageTest {

    private LionCage lionCage;
    private Lion simba;
    private Lion nala;

    @BeforeEach
    void setUp() {
        lionCage = new LionCage(2);
        simba = new Lion("Simba");
        nala = new Lion("Nala");
    }

    @Test
    @DisplayName("1. Successful Addition of Animals")
    void testAddAnimalSuccess() {
        // Empty cage initially
        assertEquals(0, lionCage.getCount());
        assertEquals(2, lionCage.getMaxCapacity());

        // Add first lion
        assertDoesNotThrow(() -> lionCage.addAnimal(simba));
        assertEquals(1, lionCage.getCount());

        // Add second lion
        assertDoesNotThrow(() -> lionCage.addAnimal(nala));
        assertEquals(2, lionCage.getCount());
    }

    @Test
    @DisplayName("2. Cage Full Exception")
    void testAddAnimalCageFullException() {
        lionCage.addAnimal(simba);
        lionCage.addAnimal(nala);

        Lion scar = new Lion("Scar");
        CageFullException exception = assertThrows(CageFullException.class, () -> {
            lionCage.addAnimal(scar);
        });
        assertEquals("Cage LionCage is full. Cannot add more animals.", exception.getMessage());
    }

    @Test
    @DisplayName("3. Successful Removal of Animals")
    void testRemoveAnimalSuccess() {
        lionCage.addAnimal(simba);
        assertEquals(1, lionCage.getCount());

        assertDoesNotThrow(() -> lionCage.removeAnimal(simba));
        assertEquals(0, lionCage.getCount());
    }

    @Test
    @DisplayName("4. Animal Not Found Exception")
    void testRemoveAnimalNotFoundException() {
        lionCage.addAnimal(simba);

        assertThrows(AnimalNotFoundException.class, () -> lionCage.removeAnimal(nala));

        assertEquals(1, lionCage.getCount());
    }

    @Test
    @DisplayName("5. Total animals count in Zoo")
    void testTotalAnimalsInZoo() {
        Zoo zoo = new Zoo();
        zoo.addNewCage(lionCage);

        UngulateCage ungulateCage = new UngulateCage(2);
        zoo.addNewCage(ungulateCage);

        assertEquals(0, zoo.getCountOfAnimals());

        lionCage.addAnimal(simba);
        ungulateCage.addAnimal(new Zebra("Marty"));
        ungulateCage.addAnimal(new Zebra("Melman"));

        assertEquals(3, zoo.getCountOfAnimals());
    }

    @Test
    @DisplayName("6. Invalid Cage Capacity")
    void testInvalidCageCapacity() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LionCage(0);
        });
        assertEquals("Max capacity must be greater than zero.", exception.getMessage());
    }
}
