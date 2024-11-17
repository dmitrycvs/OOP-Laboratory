package oop.practice.CoffeeRefactor.coffee;

import oop.practice.CoffeeRefactor.enums.Intensity;

public class PumpkinSpiceLatte extends Cappuccino{
    private int mgOfPumpkinSpice;
    private final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }
}
