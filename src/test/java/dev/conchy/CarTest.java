package dev.conchy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import dev.conchy.Car.FuelType;
import dev.conchy.Car.CarType;
import dev.conchy.Car.Color;

public class CarTest {

    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("Ford", 2003, 55, FuelType.DIESEL, CarType.COMPACT, 2, 5, 180, Color.BLACK, 0, 0.0, false);
    }

    @Test
    public void testInitialValues() {
        assertEquals("Ford", car.getBrand());
        assertEquals(2003, car.getModel());
        assertEquals(55, car.getEngineLitres());
        assertEquals(FuelType.DIESEL, car.getFuelType());
        assertEquals(CarType.COMPACT, car.getCarType());
        assertEquals(2, car.getnumberOfDoors());
        assertEquals(5, car.getNumberOfSeats());
        assertEquals(180, car.getMaxSpeed());
        assertEquals(Color.BLACK, car.getColor());
        assertEquals(0, car.getCurrentSpeed());
        assertEquals(0.0, car.getPenalty());
        assertFalse(car.getIsAutomatic());
    }

    @Test
    public void testSetters() {
        car.setBrand("Toyota");
        car.setModel(2010);
        car.setEngineLitres(60);
        car.setFuelType(FuelType.GASOLINE);
        car.setCarType(CarType.FAMILY);
        car.setnumberOfDoors(4);
        car.setNumberOfSeats(7);
        car.setMaxSpeed(200);
        car.setColor(Color.RED);
        car.setCurrentSpeed(50);
        car.setPenalty(10.0);
        car.setIsAutomatic(true);

        assertEquals("Toyota", car.getBrand());
        assertEquals(2010, car.getModel());
        assertEquals(60, car.getEngineLitres());
        assertEquals(FuelType.GASOLINE, car.getFuelType());
        assertEquals(CarType.FAMILY, car.getCarType());
        assertEquals(4, car.getnumberOfDoors());
        assertEquals(7, car.getNumberOfSeats());
        assertEquals(200, car.getMaxSpeed());
        assertEquals(Color.RED, car.getColor());
        assertEquals(50, car.getCurrentSpeed());
        assertEquals(10.0, car.getPenalty());
        assertTrue(car.getIsAutomatic());
    }

    @Test
    public void testAccelerateWithinLimit() {
        car.setCurrentSpeed(100);
        car.accelerate(20);
        assertEquals(120, car.getCurrentSpeed());
        assertEquals(0.0, car.getPenalty());
    }

    @Test
    public void testAccelerateBeyondLimit() {
        car.setCurrentSpeed(100);
        car.accelerate(30);
        assertEquals(130, car.getCurrentSpeed());
        assertEquals(50.0, car.getPenalty());
    }

    @Test
    public void testAccelerateBeyondMaxSpeed() {
        car.setCurrentSpeed(170);
        car.accelerate(20);
        assertEquals(170, car.getCurrentSpeed());
        assertEquals(50.0, car.getPenalty());
    }

    @Test
    public void testDecelerateWithinLimit() {
        car.setCurrentSpeed(100);
        car.decelerate(50);
        assertEquals(50, car.getCurrentSpeed());
    }

    @Test
    public void testDecelerateBeyondZero() {
        car.setCurrentSpeed(50);
        car.decelerate(60);
        assertEquals(50, car.getCurrentSpeed()); 
    }

    @Test
    public void testBrake() {
        car.setCurrentSpeed(100);
        car.brake();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    public void testCalculateArrivalTime() {
        car.setCurrentSpeed(60);
        assertEquals(2.0, car.calculateArrivalTime(120), 0.01);
    }

    @Test
    public void testHasPenalties() {
        assertFalse(car.hasPenalties());
        car.accelerate(200); // Penalty
        assertTrue(car.hasPenalties());
    }

    @Test
    public void testValueTotalPenalties() {
        assertEquals(0.0, car.valueTotalPenalties());
        car.accelerate(200); // Penalty
        assertEquals(50.0, car.valueTotalPenalties());
    }
}
