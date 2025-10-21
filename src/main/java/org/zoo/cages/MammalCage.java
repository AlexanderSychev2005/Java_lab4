package org.zoo.cages;

import org.zoo.animals.mammals.Mammal;

public class MammalCage <T extends Mammal>extends Cage<T> {

    public MammalCage(int maxCapacity) {
        super(maxCapacity);
    }
}
