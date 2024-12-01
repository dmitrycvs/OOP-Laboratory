package oop.practice.Task3;

import oop.practice.Car;
import oop.practice.Task1.ArrayQueue;
import oop.practice.Task2.IDineable;
import oop.practice.Task2.IRefuelable;
import oop.practice.Task4.Semaphore;

public class CarStation implements Runnable {
    private IDineable diningService;
    private IRefuelable refuelingService;
    private ArrayQueue<Car> cars = new ArrayQueue<>(50);
    private Thread stationThread;
    private int stationId;
    private final Object lock = new Object();
    private Semaphore semaphore;

    public CarStation(IDineable diningService, IRefuelable refuelingService, int stationId, Semaphore semaphore) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.stationId = stationId;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Car car;
                synchronized (lock) {
                    if (cars.isEmpty()) {
                        showStatus("Thread terminating...");
                        break;
                    }
                    car = cars.dequeue();
                }

                for (int i = 0; i < 20; i++) {
                    showStatus("[" + "#".repeat(i) + " ".repeat(20 - i) + "] " + "Processing: Car" + car.getId() + " | Cars in queue: " + cars.size());
                    Thread.sleep(car.getConsumption() * 70);
                }

                refuelingService.refuel(car.getId());
                if (car.getIsDining()) {
                    diningService.serveDinner(car.getId());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            showStatus("Thread interrupted");
        }
    }

    public void addCar(Car car) {
        synchronized (lock) {
            cars.enqueue(car);
            if (stationThread == null || !stationThread.isAlive()) {
                createAndStartThread();
            }
            lock.notify();
        }
    }

    private void createAndStartThread() {
        stationThread = new Thread(this);
        stationThread.start();
        semaphore.addStationThread(stationThread);
    }

    public int getNumberOfCars() {
        synchronized (lock) {
            return cars.size();
        }
    }

    private void showStatus(String message) {
        System.out.printf("\033[%d;0HCarStation%d: %s\033[K\n", stationId + 1, stationId, message);
        System.out.flush();
    }
}
