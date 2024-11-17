package oop.practice.Coffee;

import oop.practice.Coffee.coffee.*;
import oop.practice.Coffee.enums.*;

public class Main {
    public static void main(String[] args) {
        Coffee coffee;
        Barista barista = new Barista();
        barista.orderCoffee(new Americano(Intensity.NORMAL, 20));
        barista.orderCoffee(new Cappuccino(Intensity.LIGHT, 40));
        barista.orderCoffee(new PumpkinSpiceLatte(Intensity.STRONG, 30, 10));
        barista.orderCoffee(new SyrupCappuccino(Intensity.NORMAL, 30, SyrupType.CARAMEL));

        do {
            coffee = barista.getCoffee();
            if (coffee != null) {
                System.out.println("Coffee order!");
            }
            else {
                System.out.println("Nobody ordered the coffee");
            }
        } while (coffee != null);
    }
}