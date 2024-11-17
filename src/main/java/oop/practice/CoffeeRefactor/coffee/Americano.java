package oop.practice.CoffeeRefactor.coffee;

import oop.practice.CoffeeRefactor.enums.Intensity;

public class Americano extends Coffee{
    private int mlOfWater;
    private final String coffeeName = "Americano";
    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public String getName() {
        return coffeeName;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Water: " + mlOfWater + " ml");
    }
}
