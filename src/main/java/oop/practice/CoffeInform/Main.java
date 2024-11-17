package oop.practice.CoffeInform;

import oop.practice.CoffeInform.coffee.*;
import oop.practice.CoffeInform.enums.*;

public class Main {
    public static void main(String[] args) {
        Coffee coffee;
        Barista barista = new Barista();
        barista.orderCoffee(Americano.makeAmericano(Intensity.NORMAL, 20));
        System.out.println("-------------------------------");
        barista.orderCoffee(Cappuccino.makeCappuccino(Intensity.LIGHT, 40));
        System.out.println("-------------------------------");
        barista.orderCoffee(PumpkinSpiceLatte.makePumpkinSpiceLatte(Intensity.STRONG, 30, 10));
        System.out.println("-------------------------------");
        barista.orderCoffee(SyrupCappuccino.makeSyrupCappuccino(Intensity.NORMAL, 30, SyrupType.CARAMEL));
        System.out.println("==================================");

        do {
            coffee = barista.getCoffee();
            if (coffee != null) {
                coffee.printCoffeeDetails();
                System.out.println("-------------------------------");
            }
            else {
                System.out.println("Nobody ordered the coffee");
            }
        } while (coffee != null);
    }
}