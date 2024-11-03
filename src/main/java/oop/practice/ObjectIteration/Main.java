package oop.practice.ObjectIteration;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 300, "Display A");
        Display display2 = new Display(2560, 1440, 350, "Display B");
        Display display3 = new Display(1920, 1080, 250, "Display C");

        System.out.println("Comparing Display A and Display B:");
        display1.compareWithMonitor(display2);

        System.out.println("\nComparing Display A and Display C:");
        display1.compareWithMonitor(display3);

        System.out.println("\nComparing Display B and Display C:");
        display2.compareWithMonitor(display3);
    }
}
