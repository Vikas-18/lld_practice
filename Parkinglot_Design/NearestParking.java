package Parkinglot_Design;
public class NearestParking implements ParkingStrategy {

    @Override
    public Ticket parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        for (Floor floor : parkingLot.floors) {
            for (ParkingSpot spot : floor.parkingSpots) {
                if (spot.isAvailable && spot.spotType == vehicle.vehicleType) {
                    spot.park(vehicle);
                    System.out.println("Vehicle " + vehicle.vehicleNumber + " parked at floor " + floor.floorNumber + ", spot type " + spot.spotType);
                    return new Ticket(floor.floorNumber, spot);
                }
            }
        }
        System.out.println("No available parking spot for vehicle " + vehicle.vehicleNumber);
        return null;
    }
}
