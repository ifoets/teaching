package interview.preparation.company.interviews.design.flexera.parking.lot;

import java.time.LocalDateTime;

public class Ticket {
    int ticketId;
    ParkingSlot slot;
    Vehicle vehicle;
    LocalDateTime entryTime;
    LocalDateTime exitTime;
    double fee;
}
