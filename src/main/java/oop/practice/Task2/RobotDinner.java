package oop.practice.Task2;

public class RobotDinner implements IDineable {
    private static int robots = 0;

    @Override
    public void serveDinner(String carId) {
        robots++;
        System.out.println("Serving dinner to robots in car " + carId + ".");
    }

    public static int getRobots() {
        return robots;
    }
}
