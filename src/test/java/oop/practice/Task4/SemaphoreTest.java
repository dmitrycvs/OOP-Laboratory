package oop.practice.Task4;

import oop.practice.Car;
import org.junit.jupiter.api.Test;

public class SemaphoreTest {
    Semaphore semaphore = new Semaphore();

    Car car1 = new Car("1", "GAS", "PEOPLE", true, 12);
    Car car2 = new Car("2", "ELECTRIC", "ROBOTS", true, 11);
    Car car3 = new Car("3", "GAS", "PEOPLE", false, 13);
    Car car4 = new Car("4", "ELECTRIC", "ROBOTS", false, 10);

    @Test
    public void testSemaphore() {
        semaphore.addCarToQueue(car1);
        semaphore.addCarToQueue(car2);
        semaphore.addCarToQueue(car3);
        semaphore.addCarToQueue(car4);
        semaphore.processCars();
    }
}
