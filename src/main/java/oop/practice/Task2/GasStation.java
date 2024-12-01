package oop.practice.Task2;

public class GasStation implements IRefuelable{
    private static int gasCars = 0;

    @Override
    public void refuel(String carId) {
        gasCars++;
        System.out.println("Refueling gas car " + carId + ".");
    }

    public static int getGasCars() {
        return gasCars;
    }
}
