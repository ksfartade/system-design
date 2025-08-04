package parkinglot;  // Package name must match the folder

public class Spot {
    int id;
    String vehicleType;
    Vehicle vehicle;
    public Spot(int id, String vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.vehicle = null;
    }
}
