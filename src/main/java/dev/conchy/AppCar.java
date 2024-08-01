package dev.conchy;

import dev.conchy.Car.CarType;
import dev.conchy.Car.Color;
import dev.conchy.Car.FuelType;

public class AppCar {
 

    public static void main(String[] args) {
        
        Car car = new Car("Ford", 2003, 1.8, FuelType.DIESEL, CarType.COMPACT, 2, 5, 180, Color.BLACK, 0.0, false);
    
        car.print();

        car.setCurrentSpeed(100);
        System.out.println("Your current speed is: " + car.getCurrentSpeed() + " km/h");

        car.accelerate(20);
        System.out.println("Your current speed after accelerating is: " + car.getCurrentSpeed() + " km/h");

        car.decelerate(50);
        System.out.println("Your current speed after decelerating is: " + car.getCurrentSpeed() + " km/h");

        car.brake();
        System.out.println("You have now stopped, your speed is: " + car.getCurrentSpeed() + " km/h");


        System.out.println("Some fines?: " + car.hasPenalties());
        System.out.println("Total fines: " + car.valueTotalPenalties());
    }
}
