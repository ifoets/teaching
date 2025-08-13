package interview.preparation.company.interviews.design.flexera.parking.lot;

import org.junit.Test;

public class ParkingLotTest {


    @Test
    public void parkingLotTest() throws InterruptedException {
        ParkingLotService service = new ParkingLotService();
        Vehicle car = new Vehicle("KA01AB1234", VehicleType.CAR);

        Ticket t1 = service.parkVehicle(car);
        Thread.sleep(2000); // simulate time
        double fee = service.unparkVehicle(t1.ticketId);

        System.out.println("Fee: ₹" + fee);
    }
}
