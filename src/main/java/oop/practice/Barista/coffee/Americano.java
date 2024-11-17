package oop.practice.Barista.coffee;

import oop.practice.Barista.enums.Intensity;

public class Americano extends Coffee {
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

    @Override
    public void recipeCoffee() {
        super.recipeCoffee();
        System.out.println("Adding " + mlOfWater + " ml of water");
    }

    public static Coffee makeAmericano(Intensity intensityOfCoffee, int mlOfWater) {
        var americano = new Americano(intensityOfCoffee, mlOfWater);
        americano.recipeCoffee();
        return americano;
    }
}
