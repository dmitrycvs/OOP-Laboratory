package oop.practice.Task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StationTest {
    IRefuelable electricStation1 = new ElectricStation();
    IRefuelable electricStation2 = new ElectricStation();
    IDineable peopleDin1 = new PeopleDinner();
    IDineable peopleDin2 = new PeopleDinner();

    @Test
    public void refuelingTest() {
        electricStation1.refuel("1");
        electricStation1.refuel("2");
        electricStation2.refuel("1");
        assertEquals(3, ElectricStation.getElectricCars());
    }

    @Test
    public void dinTest() {
        peopleDin1.serveDinner("1");
        peopleDin1.serveDinner("1");
        peopleDin2.serveDinner("3");
        assertEquals(3, PeopleDinner.getPeople());
    }
}
