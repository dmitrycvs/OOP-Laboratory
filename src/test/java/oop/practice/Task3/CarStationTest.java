package oop.practice.Task3;

import oop.practice.Car;
import oop.practice.Task2.ElectricStation;
import oop.practice.Task2.GasStation;
import oop.practice.Task2.PeopleDinner;
import oop.practice.Task2.RobotDinner;
import oop.practice.Task4.Semaphore;
import org.junit.jupiter.api.Test;

public class CarStationTest {
    CarStation carStation1 = new CarStation(new PeopleDinner(), new GasStation(), 1, new Semaphore());
    CarStation carStation2 = new CarStation(new RobotDinner(), new ElectricStation(), 2, new Semaphore());

    Car car1 = new Car("1", "GAS", "PEOPLE", true, 12);
    Car car2 = new Car("2", "ELECTRIC", "ROBOTS", true, 11);
    Car car3 = new Car("3", "GAS", "PEOPLE", false, 13);
    Car car4 = new Car("4", "ELECTRIC", "ROBOTS", false, 10);

    @Test
    public void testService() {
        carStation1.addCar(car1);
        carStation1.addCar(car3);

        carStation2.addCar(car2);
        carStation2.addCar(car4);
    }
}