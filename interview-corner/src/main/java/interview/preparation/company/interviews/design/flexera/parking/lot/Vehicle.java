package interview.preparation.company.interviews.design.flexera.parking.lot;

public class Vehicle {
    String licensePlate;
    VehicleType type;
    Vehicle(String plate, VehicleType type) {
        this.licensePlate = plate;
        this.type = type;
    }
}
