package oop.practice.Coffee.coffee;

import oop.practice.Coffee.enums.Intensity;

public class Cappuccino extends Coffee {
    private int mlOfMilk;
    private final String coffee = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public String getCoffee() {
        return coffee;
    }
}
