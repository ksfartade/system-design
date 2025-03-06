package hotelmanagement;

import java.time.LocalDate;

import hotelmanagement.payment.PaymentType;

public class Test {
    public static void main(String[] args) {
        HotelManagement hotelManagement = HotelManagement.getInstance();
        hotelManagement.setupPayment();
        
        User root = hotelManagement.rootUser;
        User rajesh = hotelManagement.addStaffOrOwner(root, "Rajesh", UserType.OWNER);

        User munna = hotelManagement.addStaffOrOwner(rajesh, "Munna", UserType.STAFF);

        Room room1 = hotelManagement.addRoom(munna, RoomType.COUPLE, 1000, 4, 10000);
        Room room2 = hotelManagement.addRoom(rajesh, RoomType.SINGLEPERSON, 1000, 4, 100);
        Room room3 = hotelManagement.addRoom(munna, RoomType.LUXURY, 1000, 4, 100000);
        Room room4 = hotelManagement.addRoom(munna, RoomType.SHARED, 1000, 2, 100);
        Room room5 = hotelManagement.addRoom(munna, RoomType.COUPLE, 1000, 4, 10000);

        User guest = hotelManagement.register("tana");
        LocalDate today = LocalDate.now();
        Invoice invoice = hotelManagement.book(room5, today, today.plusDays(5), guest, PaymentType.CARD, 1000);

        boolean in = hotelManagement.checkIn(guest, invoice);
        boolean out = hotelManagement.checkOut(guest, invoice);
    }
}
