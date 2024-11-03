package oop.practice.ObjectIteration;

public class Display {
    private final int width;
    private final int height;
    private final float ppi;
    private final String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    public void compareSize(Display display) {
        int currentSize = this.height * this.width;
        int otherSize = display.height * display.width;

        if (currentSize > otherSize) {
            System.out.println(this.model + " is larger in size than " + display.model);
        } else if (currentSize < otherSize) {
            System.out.println(this.model + " is smaller in size than " + display.model);
        } else {
            System.out.println(this.model + " and " + display.model + " have the same size");
        }
    }

    public void compareSharpness(Display display) {
        if (this.ppi > display.ppi) {
            System.out.println(this.model + " is sharper than " + display.model);
        } else if (this.ppi < display.ppi) {
            System.out.println(this.model + " is less sharp than " + display.model);
        } else {
            System.out.println(this.model + " and " + display.model + " have the same sharpness");
        }
    }

    public void compareWithMonitor(Display display) {
        compareSize(display);
        compareSharpness(display);
    }
}
