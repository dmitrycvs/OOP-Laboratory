package oop.practice.CoffeInform.coffee;

import oop.practice.CoffeInform.enums.Intensity;

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

    public static Coffee makeCoffee(Intensity coffeeIntensity) {
        Coffee coffee = new Coffee(coffeeIntensity);
        System.out.println("Opening Jacobs 3 in 1");
        System.out.println("Fill it with hot water");
        return coffee;
    }
}
