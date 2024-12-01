package oop.practice.Task4;

import oop.practice.Car;
import oop.practice.Task3.CarStation;
import oop.practice.Task2.ElectricStation;
import oop.practice.Task2.GasStation;
import oop.practice.Task2.PeopleDinner;
import oop.practice.Task2.RobotDinner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Semaphore {
    private CarStation carStation1 = new CarStation(new PeopleDinner(), new GasStation(), 1, this);
    private CarStation carStation2 = new CarStation(new PeopleDinner(), new ElectricStation(), 2, this);
    private CarStation carStation3 = new CarStation(new RobotDinner(), new GasStation(), 3, this);
    private CarStation carStation4 = new CarStation(new RobotDinner(), new ElectricStation(), 4, this);

    private CopyOnWriteArrayList<Thread> stationThreads = new CopyOnWriteArrayList<>();

    public void navigateCars(Car car) {
        if (car.getIsDining()) {
            switch (car.getPassangers()) {
                case "PEOPLE" -> {
                    switch (car.getType()) {
                        case "GAS" -> carStation1.addCar(car);
                        case "ELECTRIC" -> carStation2.addCar(car);
                    }
                }
                case "ROBOTS" -> {
                    switch (car.getType()) {
                        case "GAS" -> carStation3.addCar(car);
                        case "ELECTRIC" -> carStation4.addCar(car);
                    }
                }
            }
        } else {
            switch (car.getType()) {
                case "GAS" -> {
                    if (carStation1.getNumberOfCars() <= carStation3.getNumberOfCars()) {
                        carStation1.addCar(car);
                    } else {
                        carStation3.addCar(car);
                    }
                }
                case "ELECTRIC" -> {
                    if (carStation2.getNumberOfCars() <= carStation4.getNumberOfCars()) {
                        carStation2.addCar(car);
                    } else {
                        carStation4.addCar(car);
                    }
                }
            }
        }
    }

    public void waitForAllThreads() throws InterruptedException {
        for (Thread thread : stationThreads) {
            thread.join();
        }
    }

    public void addStationThread(Thread thread) {
        stationThreads.add(thread);
    }

    public void showStatistics() {
        System.out.printf("%-20s: %d\n", "Gas cars", GasStation.getGasCars());
        System.out.printf("%-20s: %d\n", "Electric cars", ElectricStation.getElectricCars());
        System.out.printf("%-20s: %d\n", "People", PeopleDinner.getPeople());
        System.out.printf("%-20s: %d\n", "Robots", RobotDinner.getRobots());
    }
}
