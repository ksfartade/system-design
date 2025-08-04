package parkinglot;

import java.util.*;

public class Level{
    List<Spot> spots = new ArrayList<>();

    public Level(int bikes, int cars) {
        spots = new ArrayList<>();
        for(int i=0; i<bikes; i++){
            spots.add(new Spot(i,"2-Wheeler"));
        }
        for(int i=bikes; i<bikes+cars; i++){
            spots.add(new Spot(i,"4-Wheeler"));
        }
    }

    public synchronized Spot park(Vehicle vehicle) {
        for(Spot spotTemp : spots){
            Spot spot = spotTemp;
            if(spot.vehicle == null && spot.vehicleType.equals(vehicle.vehicleType)){
                return spot;
            }
        }
        return null;
    }

    public void unPartk(Spot spotTemp) {
        Spot spot = spotTemp;
        spot.vehicle = null;
        spot.vehicleType = null;
    }
    
}
