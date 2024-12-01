package oop.practice.Task2;

public class ElectricStation implements IRefuelable {
    private static int electricCars = 0;

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling electric car " + carId + ".");
        electricCars++;
    }

    public static int getElectricCars() {
        return electricCars;
    }
}
