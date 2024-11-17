package oop.practice.CoffeeRefactor.coffee;

import oop.practice.CoffeeRefactor.enums.Intensity;

public class Coffee {
    private Intensity coffeeIntensity;
    private final String name = "Coffee";

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee name: " + getName());
        System.out.println("Intensity: " + coffeeIntensity);
    }
}
