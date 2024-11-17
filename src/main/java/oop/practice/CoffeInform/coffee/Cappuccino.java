package oop.practice.CoffeInform.coffee;

import oop.practice.CoffeInform.enums.Intensity;

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

    public static Coffee makeCappuccino(Intensity intensity, int mlOfMilk) {
        var cappuccino = new Cappuccino(intensity, mlOfMilk);
        System.out.println("Making " + cappuccino.coffee);
        System.out.println("Intensity set to " + intensity);
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        return cappuccino;
    }
}
