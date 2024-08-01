package dev.conchy;

public class Car {
    private String brand;
    private int model;
    private int engineLitres;

    enum FuelType {
        GASOLINE, DIESEL, BIODIESEL, NATURAL_GAS, ELECTRIC, HYBRID
    }

    FuelType fuelType;

    enum CarType {
        CITY, COMPACT, FAMILY, EXECUTIVE
    }

    private CarType carType;
    private int numberOfDoors;
    private int numberOfSeats;
    private int maxSpeed;

    enum Color {
        WHITE, PEARL, RED, BLUE, PINK, BLACK, GREY
    }

    private Color color;
    private int currentSpeed = 0;

    private Double penalty = 0.0;
    private Boolean isAutomatic;

    public Car(String brand, int model, int engineLitres, FuelType fuelType, CarType carType, int numberOfDoors,
            int numberOfSeats, int maxSpeed, Color color, int currentSpeed, Double penalty, Boolean isAutomatic) {
        this.brand = brand;
        this.model = model;
        this.engineLitres = engineLitres;
        this.fuelType = fuelType;
        this.carType = carType;
        this.numberOfDoors = numberOfDoors;
        this.numberOfSeats = numberOfSeats;
        this.maxSpeed = maxSpeed;
        this.color = color;
        this.currentSpeed = currentSpeed;
        this.penalty = penalty;
        this.isAutomatic = isAutomatic;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public int getEngineLitres() {
        return engineLitres;
    }

    public void setEngineLitres(int engineLitres) {
        this.engineLitres = engineLitres;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getnumberOfDoors() {
        return numberOfDoors;
    }

    public void setnumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public Double getPenalty() {
        return penalty;
    }

    public void setPenalty(Double penalty) {
        this.penalty = penalty;
    }

    public Boolean getIsAutomatic() {
        return isAutomatic;
    }

    public void setIsAutomatic(Boolean isAutomatic) {
        this.isAutomatic = isAutomatic;
    }

    void accelerate(int speedIncrement) {
        if (currentSpeed + speedIncrement <= maxSpeed) {
            currentSpeed += speedIncrement;
            if (currentSpeed > 120) {
            System.out.println("Speed exceeds 120 km/h. Penalty applied. Actual penalty: " + penalty);
        }
    } else {
        penalty += 50;
        System.out.println("Cannot increase to a speed higher than the car's maximum speed. Actual penalty: " + penalty);
    }
}

    void decelerate(int speedDecrement) {
        if ((currentSpeed - speedDecrement) > 0) {
            currentSpeed -= speedDecrement;
        } else {
            System.out.println("Cannot decrease to a negative speed.");
        }
    }

    void brake() {
        currentSpeed = 0;
    }

    double calculateArrivalTime(int distance) {
        return (double) distance / currentSpeed;
    }

    public boolean hasPenalties() {
        return penalty > 0;
    }

    public double valueTotalPenalties() {
        return penalty;
    }


void print() {
    System.out.println("Brand = " + brand);
    System.out.println("Model = " + model);
    System.out.println("Engine = " + engineLitres);
    System.out.println("Fuel Type = " + fuelType);
    System.out.println("Car Type = " + carType);
    System.out.println("Number of Doors = " + numberOfDoors);
    System.out.println("Number of Seats = " + numberOfSeats);
    System.out.println("Max Speed = " + maxSpeed + " km/h");
    System.out.println("Color = " + color);
    System.out.println("Automatic = " + (isAutomatic ? "Yes" : "No"));
}

}


