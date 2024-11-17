package oop.practice.Barista.barista;

import oop.practice.Barista.coffee.*;
import oop.practice.Barista.enums.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Barista {
    private String orderID;
    private HashMap<String, Coffee> coffees = new HashMap<>();

    public Barista() {
    }

    private int askForPumpkin() {
        int mg = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.print("\nEnter mg of pumpkin spice: ");
                String s = br.readLine();
                try {
                    mg = Integer.parseInt(s);
                    if (mg < 10 || mg > 3000) {
                        System.out.println("The coffee will taste bad.");
                        System.out.println("Please specify another quantity.");
                    }
                    else {
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid pumpkin spice number");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return mg;
    }

    private int askForMilk() {
        int milk = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.print("\nEnter ml of milk: ");
                String s = br.readLine();
                try {
                    milk = Integer.parseInt(s);
                    if (milk < 10 || milk > 100) {
                        System.out.println("The coffee will taste bad.");
                        System.out.println("Please specify another quantity.");
                    }
                    else {
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid milk number");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return milk;
    }

    private int askForWater() {
        int water = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while (true) {
                System.out.print("\nEnter ml of water: ");
                String s = br.readLine();
                try {
                    water = Integer.parseInt(s);
                    if (water < 10 || water > 100) {
                        System.out.println("The coffee will taste bad.");
                        System.out.println("Please specify another quantity.");
                    }
                    else {
                        break;
                    }
                }catch (NumberFormatException e){
                    System.out.println("Invalid water number");
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return water;
    }

    private Intensity askForIntensity() {
        int intensity = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nSelect an intensity: ");
        System.out.println("1. Light");
        System.out.println("2. Normal");
        System.out.println("3. Strong");

        try {
            while (true) {
                System.out.print("Type the number: ");
                String s = br.readLine();
                try {
                    intensity = Integer.parseInt(s);
                    if (intensity < 1 || intensity > 3) {
                        System.out.println("Invalid intensity");
                    }
                    else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid intensity");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (intensity) {
            case 1 -> {
                return Intensity.LIGHT;
            }
            case 2 -> {
                return Intensity.NORMAL;
            }
            case 3 -> {
                return Intensity.STRONG;
            }
        }
        return Intensity.NORMAL;
    }

    private SyrupType askForSyrup() {
        int syrup = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nSelect an intensity: ");
        System.out.println("1. Macadamia");
        System.out.println("2. Vanilla");
        System.out.println("3. Coconut");
        System.out.println("4. Caramel");
        System.out.println("5. Chocolate");
        System.out.println("6. Popcorn");

        try {
            while (true) {
                System.out.print("Type the number: ");
                String s = br.readLine();
                try {
                    syrup = Integer.parseInt(s);
                    if (syrup < 1 || syrup > 6) {
                        System.out.println("Invalid syrup");
                    }
                    else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid syrup");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (syrup) {
            case 1 -> {
                return SyrupType.MACADAMIA;
            }
            case 2 -> {
                return SyrupType.VANILLA;
            }
            case 3 -> {
                return SyrupType.COCONUT;
            }
            case 4 -> {
                return SyrupType.CARAMEL;
            }
            case 5 -> {
                return SyrupType.CHOCOLATE;
            }
            case 6 -> {
                return SyrupType.POPCORN;
            }
        }
        return SyrupType.VANILLA;
    }

    public void orderCoffee() throws InterruptedException {
        Coffee coffee = null;
        String name = "Noname";
        System.out.println("\nWhich coffee would you like to order?");
        System.out.println("1. Simple coffee");
        System.out.println("2. Americano");
        System.out.println("3. Cappuccino");
        System.out.println("4. Pumpkin Spice Latte");
        System.out.println("5. Syrup Cappuccino");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = 0;

        try {
            while (true) {
                System.out.print("Type the number: ");
                String number = reader.readLine();
                try {
                    choice = Integer.parseInt(number);
                    if (choice < 1 || choice > 5) {
                        System.out.println("Please enter a number between 1 and 5");
                    }
                    else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number");
                }
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        Intensity intensity = askForIntensity();
        switch (choice) {
            case 1 -> {

                coffee = Coffee.makeCoffee(intensity);
            }
            case 2 -> {
                int water = askForWater();
                coffee = Americano.makeAmericano(intensity, water);
            }
            case 3 -> {
                int milk = askForMilk();
                coffee = Cappuccino.makeCappuccino(intensity, milk);
            }
            case 4 -> {
                int milk = askForMilk();
                int pumpkin = askForPumpkin();
                coffee = PumpkinSpiceLatte.makePumpkinSpiceLatte(intensity, milk, pumpkin);
            }
            case 5 -> {
                int milk = askForMilk();
                SyrupType syrup = askForSyrup();
                coffee = SyrupCappuccino.makeSyrupCappuccino(intensity, milk, syrup);
            }
        }

        System.out.print("\nWhat's your name: ");
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        int total = 50;
        System.out.print("Preparing the cofee, wait!\n");

        for (int i = 0; i < total; i++) {
            Thread.sleep(100);
        }

        coffees.put(name, coffee);
        System.out.println("The order has been completed!");
    }

    public void getCoffee() {
        System.out.println("\nCompleted coffee: ");
        if (coffees.isEmpty()) {
            System.out.println("Nobody ordered the coffee!");
            return;
        }
        for (String name : coffees.keySet()) {
            System.out.println(coffees.get(name).getName() + " for " + name);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String id = null;
        try {
            System.out.print("Enter your name: ");
            id = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Coffee c = coffees.get(id);
        if (c == null) {
            System.out.println("There is no coffee for you!");
        }
        else {
            coffees.remove(id);
            System.out.println("Coffee for " + id + "!");
            c.printCoffeeDetails();
            System.out.println("Thank you!");
        }
    }
}
