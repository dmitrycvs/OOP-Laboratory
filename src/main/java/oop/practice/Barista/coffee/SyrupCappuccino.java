package oop.practice.Barista.coffee;

import oop.practice.Barista.enums.Intensity;
import oop.practice.Barista.enums.SyrupType;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensity, int mlOfMilk,SyrupType syrup) {
        super(intensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return coffee;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup: " + syrup);
    }

    @Override
    public void recipeCoffee() {
        super.recipeCoffee();
        System.out.println("Adding " + syrup + " syrup");
    }

    public static Coffee makeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        var syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        syrupCappuccino.recipeCoffee();
        return syrupCappuccino;
    }
}
