package oop.practice.Task2;

public class PeopleDinner implements IDineable {
    private static int people = 0;

    @Override
    public void serveDinner(String carId) {
        people++;
        System.out.println("Serving dinner to people in car " + carId + ".");
    }

    public static int getPeople() {
        return people;
    }
}
