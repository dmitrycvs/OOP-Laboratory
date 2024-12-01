package oop.practice.Task3;

import oop.practice.Car;
import oop.practice.Task2.IDineable;
import oop.practice.Task2.IRefuelable;
import oop.practice.Task1.ArrayQueue;

import java.lang.reflect.Array;

public class CarStation {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private ArrayQueue<Car> queue;

    public CarStation(IDineable diningService, IRefuelable refuelingService, ArrayQueue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            if (car.getIsDining()) {
                diningService.serveDinner(car.getId());
            }
            refuelingService.refuel(car.getId());
        }
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }
}
