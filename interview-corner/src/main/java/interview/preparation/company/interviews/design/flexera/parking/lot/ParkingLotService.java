package interview.preparation.company.interviews.design.flexera.parking.lot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotService {
    private Map<Integer, ParkingSlot> slots = new HashMap<>();
    private Map<Integer, Ticket> activeTickets = new HashMap<>();
    private int ticketCounter = 1;

    public ParkingLotService() {
        // initialize some slots
        slots.put(1, new ParkingSlot(1, VehicleType.CAR));
        slots.put(2, new ParkingSlot(2, VehicleType.BIKE));
        slots.put(3, new ParkingSlot(3, VehicleType.CAR));
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        for (ParkingSlot slot : slots.values()) {
            if (slot.type == vehicle.type && slot.status == SlotStatus.FREE) {
                slot.status = SlotStatus.OCCUPIED;
                Ticket ticket = new Ticket();
                ticket.ticketId = ticketCounter++;
                ticket.slot = slot;
                ticket.vehicle = vehicle;
                ticket.entryTime = LocalDateTime.now();
                activeTickets.put(ticket.ticketId, ticket);
                System.out.println("Vehicle parked in slot " + slot.id);
                return ticket;
            }
        }
        System.out.println("No available slot for " + vehicle.type);
        return null;
    }

    public double unparkVehicle(int ticketId) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket != null) {
            ticket.exitTime = LocalDateTime.now();
            ticket.fee = calculateFee(ticket.entryTime, ticket.exitTime);
            ticket.slot.status = SlotStatus.FREE;
            System.out.println("Vehicle unparked from slot " + ticket.slot.id);
            return ticket.fee;
        }
        System.out.println("Invalid ticket");
        return 0;
    }

    private double calculateFee(LocalDateTime entry, LocalDateTime exit) {
        long hours = Math.max(1, Duration.between(entry, exit).toHours());
        return hours * 10.0; // flat rate ₹10 per hour
    }
}