package Parkinglot_Design;
public class Ticket {
    String id;
    int floorNumber;
    String spotId;
    ParkingSpot parkingSpot;
    String arrivalTime; // Assuming you want to store the date and time of parking

    Ticket(int floorNumber, ParkingSpot parkingSpot) {
        this.id = java.util.UUID.randomUUID().toString();
        this.floorNumber = floorNumber;
        this.parkingSpot = parkingSpot;
        this.spotId = parkingSpot.id;
        this.arrivalTime = java.time.LocalDateTime.now().toString();
    }

    public String getId() {
        return id;
    }
}
