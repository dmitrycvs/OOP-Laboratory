package oop.practice.Barista;

import oop.practice.Barista.barista.Barista;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Barista barista = new Barista();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean running = true;

        while (running) {
            System.out.println("\nBarista:");
            System.out.println("1. Order a coffee");
            System.out.println("2. Get your coffee");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            try {
                int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 1 -> barista.orderCoffee();
                    case 2 -> barista.getCoffee();
                    case 3 -> {
                        System.out.println("See ya then!");
                        running = false;
                    }
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
}