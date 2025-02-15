package parkinglot;

import java.util.*;

public class ParkingLot {
    List<Level> levels = new ArrayList<>();
    public static ParkingLot parkingLot;

    private ParkingLot() {}

    public static synchronized ParkingLot getObj(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public synchronized void addLevel(Level level){
        levels.add(level);
    }

    public synchronized Spot parkVehicle(Vehicle vehicle){
        for(Level level: levels){
            Spot spot = level.park(vehicle);
            if(spot != null){
                return spot;
            }
        }

        return null;
    }

    public void unPark(Spot spot){
        spot.vehicle = null;
        System.out.println("Vehicle unparked successfully.");
    }
}
