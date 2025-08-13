package interview.preparation.company.interviews.design.flexera.parking.lot;

public class  ParkingSlot {
    int id;
    VehicleType type;
    SlotStatus status = SlotStatus.FREE;
    ParkingSlot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }
}
