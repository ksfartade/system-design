package carrentalsystem;
import java.time.LocalDate;

public class Invoice {
    User user;
    int amountPaid;
    Car car;
    LocalDate startDate, endDate;
    public Invoice(User user, int amountPaid, Car car, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.amountPaid = amountPaid;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
