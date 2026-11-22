package Parkinglot_Design;
import java.util.List;

public class Floor {
    int floorNumber;
    List<ParkingSpot> parkingSpots;

    public Floor(int floorNumber, List<ParkingSpot> parkingSpots) {
        this.floorNumber = floorNumber;
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            throw new IllegalArgumentException("parkingSpots cannot be null or empty");
        }
        this.parkingSpots = parkingSpots;
    }


}
