package oop.practice.Coffee.coffee;

import oop.practice.Coffee.enums.Intensity;

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
    public String getCoffeeName() {
        return coffeeName;
    }
}
