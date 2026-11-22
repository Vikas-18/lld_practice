package Parkinglot_Design;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Floor firstFloor = new Floor(1, Arrays.asList(
                new ParkingSpot(Type.BIKE),
                new ParkingSpot(Type.CAR),
                new ParkingSpot(Type.TRUCK)
        ));

        Floor secondFloor = new Floor(2, Arrays.asList(
                new ParkingSpot(Type.BIKE),
                new ParkingSpot(Type.CAR),
                new ParkingSpot(Type.TRUCK)
        ));

        ParkingLot parkingLot = new ParkingLot(Arrays.asList(firstFloor, secondFloor));
        ParkingStrategy parkingStrategy = new NearestParking();

        Vehicle bike = new Vehicle("BIKE123", Type.BIKE);
        Vehicle car = new Vehicle("CAR456", Type.CAR);
        Vehicle truck = new Vehicle("TRUCK789", Type.TRUCK);

        Ticket bikeTicket = parkingLot.parkVehicle(bike, parkingStrategy);
        Ticket carTicket = parkingLot.parkVehicle(car, parkingStrategy);
        Ticket truckTicket = parkingLot.parkVehicle(truck, parkingStrategy);

        System.out.println("Created 2 floors with 3 spots each.");
        System.out.println("Bike ticket: " + bikeTicket.getId());
        System.out.println("Car ticket: " + carTicket.getId());
        System.out.println("Truck ticket: " + truckTicket.getId());

        //unpark vehicles
        parkingLot.unParkVehicle(bikeTicket.getId(), new UPI(), new HourlyPricing());
    }
}
