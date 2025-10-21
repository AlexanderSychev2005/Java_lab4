package org.zoo.animals;

public abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " named " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return java.util.Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, getClass());
    }
}
