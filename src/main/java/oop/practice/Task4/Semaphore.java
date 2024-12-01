package oop.practice.Task4;

import oop.practice.Car;
import oop.practice.Task1.ArrayQueue;
import oop.practice.Task2.ElectricStation;
import oop.practice.Task2.GasStation;
import oop.practice.Task2.PeopleDinner;
import oop.practice.Task2.RobotDinner;
import oop.practice.Task3.CarStation;

public class Semaphore {
    private ArrayQueue<Car> waitingCarsQueue = new ArrayQueue<>(10);
    private CarStation gasStationForPeople = new CarStation(new PeopleDinner(), new GasStation(), waitingCarsQueue);
    private CarStation electricStationForPeople = new CarStation(new PeopleDinner(), new ElectricStation(), waitingCarsQueue);
    private CarStation gasStationForRobots = new CarStation(new RobotDinner(), new GasStation(), waitingCarsQueue);
    private CarStation electricStationForRobots = new CarStation(new RobotDinner(), new ElectricStation(), waitingCarsQueue);

    public void addCarToQueue(Car car) {
        waitingCarsQueue.enqueue(car);
    }

    public void processCars() {
        while (!waitingCarsQueue.isEmpty()) {
            Car currentCar = waitingCarsQueue.dequeue();
            if (currentCar.getIsDining()) {
                routeDiningCar(currentCar);
            } else {
                routeRegularCar(currentCar);
            }
        }
    }

    private void routeDiningCar(Car car) {
        switch (car.getPassangers()) {
            case "PEOPLE" -> routeDiningCarForPeople(car);
            case "ROBOTS" -> routeDiningCarForRobots(car);
        }
    }

    private void routeDiningCarForPeople(Car car) {
        if ("GAS".equals(car.getType())) {
            gasStationForPeople.addCar(car);
        } else if ("ELECTRIC".equals(car.getType())) {
            electricStationForPeople.addCar(car);
        }
    }

    private void routeDiningCarForRobots(Car car) {
        if ("GAS".equals(car.getType())) {
            gasStationForRobots.addCar(car);
        } else if ("ELECTRIC".equals(car.getType())) {
            electricStationForRobots.addCar(car);
        }
    }

    private void routeRegularCar(Car car) {
        if ("GAS".equals(car.getType())) {
            routeGasCar(car);
        } else if ("ELECTRIC".equals(car.getType())) {
            routeElectricCar(car);
        }
    }

    private void routeGasCar(Car car) {
        if (gasStationForPeople.getNumberOfCars() <= gasStationForRobots.getNumberOfCars()) {
            gasStationForPeople.addCar(car);
        } else {
            gasStationForRobots.addCar(car);
        }
    }

    private void routeElectricCar(Car car) {
        if (electricStationForPeople.getNumberOfCars() <= electricStationForRobots.getNumberOfCars()) {
            electricStationForPeople.addCar(car);
        } else {
            electricStationForRobots.addCar(car);
        }
    }
}

