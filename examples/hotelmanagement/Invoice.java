package hotelmanagement;

import java.time.LocalDate;

public class Invoice {
    User user;
    Room room;
    LocalDate starDate, enDate;
    public Invoice(User user, Room room, LocalDate starDate, LocalDate enDate) {
        this.user = user;
        this.room = room;
        this.starDate = starDate;
        this.enDate = enDate;
    }
    
}
