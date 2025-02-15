package parkinglot;

public class Test {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getObj();

        Level level1 = new Level(10, 10);
        Level level2 = new Level(20, 20);

        parkingLot.addLevel(level1);
        parkingLot.addLevel(level2);

        Vehicle vehicle = new Vehicle(1234, "2-Wheeler");

        Spot spot = parkingLot.parkVehicle(vehicle);
        System.out.println("Your parking slot is: " + spot.id);
        parkingLot.unPark(spot);
        System.out.println("Visit again..");
    }
}
