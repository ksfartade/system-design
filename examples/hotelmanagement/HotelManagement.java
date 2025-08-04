package hotelmanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hotelmanagement.payment.CardPayment;
import hotelmanagement.payment.Payment;
import hotelmanagement.payment.PaymentType;
import hotelmanagement.payment.UPIPayment;

public class HotelManagement {
    private int roomId = 0, userId = 0 ;

    HashMap<RoomType, List<Room>> rooms = new HashMap<>();
    HashMap<UserType, List<User>> users = new HashMap<>();
    User rootUser = new User(UserType.OWNER, 0, "root");
    HashMap<PaymentType, Payment> availablePayments = new HashMap<>();

    private static HotelManagement hotelManagement = new HotelManagement();

    public static HotelManagement getInstance(){
        return hotelManagement;
    }

    public void setupPayment(){
        availablePayments.put(PaymentType.CARD, CardPayment.getInstance());
        availablePayments.put(PaymentType.UPI, UPIPayment.getInstance());
        availablePayments.put(PaymentType.CARD, CardPayment.getInstance());
    }


    public User addStaffOrOwner(User owner, String userName, UserType userType){
        if(owner.userType != UserType.OWNER){
            System.out.println("You don't have a permission to add staff. You must be owner to add staff");
            return null;
        }
        User user = new User(userType, ++userId, userName);
        System.out.println("User added successfully..");
        users.putIfAbsent(userType, new ArrayList<>());
        users.get(userType).add(user);
        return user;
    }

    public User register(String userName){
        User user = new User(UserType.GUEST, ++userId, userName);
        System.out.println("User added successfully..");
        users.putIfAbsent(UserType.GUEST, new ArrayList<>());
        users.get(UserType.GUEST).add(user);
        return user;
    }

    public Room addRoom(User user, RoomType roomType, int area, int floor, int pricePerDay){
        if(user.userType != UserType.OWNER && user.userType != UserType.STAFF){
            System.out.println("You don't have the permission to add rooms");
            return null;
        }

        Room room = new Room(++roomId, floor, area, roomType, pricePerDay);
        rooms.putIfAbsent(roomType, new ArrayList<>());
        rooms.get(roomType).add(room);
        System.out.println("Room added succeffully...");
        return room;
    }

    public synchronized Invoice book(Room room, LocalDate startDate, LocalDate endDate, User user, PaymentType paymentType, int amount){
        if(!room.isAvailable(startDate, endDate)){
            System.out.println("Room already booked. Please select another room");
            return null;
        }
        
        Payment paymentMethod = availablePayments.get(paymentType);

        if(!paymentMethod.process(amount)){
            System.out.println("Payment failed please try again..");
            return null;
        }

        room.book(startDate, endDate);

        Invoice invoice = new Invoice(user, room, startDate, endDate);
        System.out.println("Room booked successfully...");
        return invoice;
    }

    public boolean checkIn(User user, Invoice invoice){
        if(invoice.room.in){
            System.out.println("Someone already checked in....");
            return false;
        }
        if(invoice.user != user){
            System.out.println("You don't have permission to check in..");
        }
        LocalDate today = LocalDate.now();
        if((today.isAfter(invoice.starDate) || today.isEqual(invoice.starDate))  && (today.isBefore(invoice.enDate) || today.isEqual(invoice.enDate))){
            invoice.room.in = true;
            System.out.println("Successsfully checked in..");
            return true;
        }
        System.out.println("Expired or invalid invoice...");
        return false;
    }

    public boolean checkOut(User user, Invoice invoice){
        if(invoice.user.id != user.id){
            System.out.println("You don't have permission...");
            return false;
        }
        LocalDate today = LocalDate.now();
        if((today.isAfter(invoice.starDate) || today.isEqual(invoice.starDate))  && (today.isBefore(invoice.enDate) || today.isEqual(invoice.enDate))){
            invoice.room.in = false;
            System.out.println("Successsfully checked out..");
            return true;
        }
        System.out.println("Invalid invoice...");
        return false;
    }

}
