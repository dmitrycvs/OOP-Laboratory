package oop.practice.Task3;

import oop.practice.Car;
import oop.practice.Task1.Queue;
import oop.practice.Task2.IDineable;
import oop.practice.Task2.IRefuelable;
import oop.practice.Task4.Semaphore;

public class CarStation implements Runnable {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private Queue<Car> cars = new Queue<>();
    private Thread thread;
    private int stationId;
    private final Object queueLock = new Object();
    private Semaphore semaphore;

    public CarStation(IDineable diningService, IRefuelable refuelingService, int stationId, Semaphore semaphore) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.stationId = stationId;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            Car car;
                synchronized (queueLock) {
                    if (cars.isEmpty()) {
                        updateTerminal("Thread terminating...");
                        break;
                    }
                    car = cars.dequeue();
                }

                System.out.println("-----------------------------");
                System.out.println("Car Station " + stationId + ":");
                refuelingService.refuel(car.getId());
                if (car.getIsDining()) diningService.serveDinner(car.getId());
                System.out.println("-----------------------------");
            }
    }

    public void addCar(Car car) {
        synchronized (queueLock) {
            cars.enqueue(car);
            if (thread == null || !thread.isAlive()) {
                startThread();
            }
            queueLock.notify();
        }
    }

    private void startThread() {
        thread = new Thread(this);
        thread.start();
        semaphore.addStationThread(thread);
    }

    public int getNumberOfCars() {
        synchronized (queueLock) {
            return cars.size();
        }
    }

    private void updateTerminal(String status) {
        System.out.printf("\033[%d;0HCarStation%d: %s\033[K\n", stationId + 1, stationId, status);
        System.out.flush();
    }
}


