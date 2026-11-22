package Parkinglot_Design;
public class Vehicle {
    String vehicleNumber;
    Type vehicleType;

    Vehicle(String vehicleNumber, Type vehicleType) {
        if (vehicleNumber == null || vehicleType == null) {
            throw new IllegalArgumentException("Vehicle number and type cannot be null");
        }
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }
}
