package Parkinglot_Design;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<Floor> floors;
    private final Map<String, Ticket> activeTickets = new HashMap<>();

    public ParkingLot(List<Floor> floors) {
        this.floors = floors;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle, ParkingStrategy strategy) {
        Ticket ticket = strategy.parkVehicle(vehicle, ParkingLot.this);
        if (ticket != null) {
            activeTickets.put(ticket.id, ticket);
        }
        return ticket;
    }

    public synchronized void unParkVehicle(String ticketId,PaymentStrategy paymentStrategy,PricingStrategy pricingStrategy) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found: " + ticketId);
        }

        int amount = pricingStrategy.calculatePrice(ticket);
        paymentStrategy.processPayment(amount);
        ticket.parkingSpot.unPark();
        activeTickets.remove(ticketId);
        System.out.println("Vehicle unparked from floor " + ticket.floorNumber);
    }
}
