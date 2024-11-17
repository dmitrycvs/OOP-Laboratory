package oop.practice.Coffee.coffee;

import oop.practice.Coffee.enums.Intensity;
import oop.practice.Coffee.enums.SyrupType;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensity, int mlOfMilk,SyrupType syrup) {
        super(intensity, mlOfMilk);
        this.syrup = syrup;
    }

    public String getCoffee() {
        return coffee;
    }

    public SyrupType getSyrup() {
        return syrup;
    }
}
