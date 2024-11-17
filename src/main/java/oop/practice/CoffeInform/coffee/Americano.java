package oop.practice.CoffeInform.coffee;

import oop.practice.CoffeInform.enums.Intensity;

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

    public static Coffee makeAmericano(Intensity intensityOfCoffee, int mlOfWater) {
        var americano = new Americano(intensityOfCoffee, mlOfWater);
        System.out.println("Making " + americano.coffeeName);
        System.out.println("Intensity set to " + intensityOfCoffee);
        System.out.println("Adding " + mlOfWater + " ml of water");
        return americano;
    }
}
