package Parkinglot_Design;
public class ParkingSpot {
    Type spotType;
    boolean isAvailable;
    String id;
    public ParkingSpot(Type spotType) {
        if (spotType == null) {
            throw new IllegalArgumentException("spotType cannot be null");
        }
        this.spotType = spotType;
        this.id = java.util.UUID.randomUUID().toString();
        this.isAvailable = true;
    }

    

    public void park(Vehicle vehicle) {
        if (!isAvailable) {
            throw new IllegalStateException("Parking spot is already occupied");
        }
        if (vehicle.vehicleType != this.spotType) {
            throw new IllegalArgumentException("Vehicle type does not match parking spot type");
        }
        isAvailable = false;
    }


    public void unPark() {
        if (isAvailable) {
            throw new IllegalStateException("Parking spot is already available");
        }
        isAvailable = true;
    }
}
