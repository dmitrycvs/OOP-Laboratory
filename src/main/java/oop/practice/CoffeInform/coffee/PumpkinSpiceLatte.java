package oop.practice.CoffeInform.coffee;

import oop.practice.CoffeInform.enums.Intensity;

public class PumpkinSpiceLatte extends Cappuccino {
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

    public static PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        var pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        System.out.println("Making " + pumpkinSpiceLatte.name);
        System.out.println("Intensity set to " + pumpkinSpiceLatte.getCoffeeIntensity());
        System.out.println("Adding " + pumpkinSpiceLatte.getMlOfMilk() + " ml of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkins");
        return pumpkinSpiceLatte;
    }
}
