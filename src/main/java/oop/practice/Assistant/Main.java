package oop.practice.Assistant;

import oop.practice.ObjectIteration.Display;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 92.5f, "Model A");
        Display display2 = new Display(2560, 1440, 109.8f, "Model B");
        Display display3 = new Display(3840, 2160, 137.6f, "Model C");

        Assistant assistant = new Assistant("Display Assistant");
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);

        System.out.println("Display comparisons:");
        assistant.assist();
    }
}
