package oop.practice.Barista.coffee;

import oop.practice.Barista.enums.Intensity;

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

    @Override
    public String getName() {
        return coffee;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Milk: " + mlOfMilk + " ml");
    }

    @Override
    public void recipeCoffee() {
        super.recipeCoffee();
        System.out.println("Adding " + mlOfMilk + " ml of milk");
    }

    public static Coffee makeCappuccino(Intensity intensity, int mlOfMilk) {
        var cappuccino = new Cappuccino(intensity, mlOfMilk);
        cappuccino.recipeCoffee();
        return cappuccino;
    }
}
