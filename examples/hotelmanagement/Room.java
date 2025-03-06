package hotelmanagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Room {
    int id, floor, area, pricePerDay;
    RoomType roomType;
    HashMap<LocalDate, LocalDate> reserved;
    boolean in;

    public Room(int id, int floor, int area, RoomType roomType, int pricePerDay) {
        this.id = id;
        this.floor = floor;
        this.area = area;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        reserved = new HashMap<>();
        in = false;
    }


    public synchronized boolean isAvailable(LocalDate starDate, LocalDate enDate){
        for(Map.Entry<LocalDate, LocalDate>entry: reserved.entrySet()){
            if((starDate.isAfter(entry.getKey()) && starDate.isBefore(entry.getValue())) || (enDate.isAfter(entry.getKey()) && enDate.isBefore(entry.getValue()))){
                return false;
            }
        }
        return true;
    }

    public synchronized void book(LocalDate starDate, LocalDate enDate){
        reserved.put(starDate, enDate);
    }
}
