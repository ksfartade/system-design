package carrentalsystem;

import java.time.LocalDate;
import java.util.List;

import carrentalsystem.payment.CreditCardPayment;
import carrentalsystem.payment.Payment;
import carrentalsystem.payment.PaymentType;
import carrentalsystem.payment.UPIPayment;

public class Test {
    public static void main(String[] args) {
        
        CarRent carRent = CarRent.getInstance();
        User user1 = carRent.addUser("Rajesh", "129312983", "888888888");
        User user2 = carRent.addUser("Mukesh", "aksdjf", "8899988899");
        User user3 = carRent.addUser("Gukesh", "aksdjf", "8899988899");
        User user4 = carRent.addUser("Pragya", "aksdjf", "8899988899");
    
        Car car1 = carRent.addCar(2001, "BS6", "Tata", "Bh2398", "curve", CarType.XUV, 1000, user1);
        Car car2 = carRent.addCar(2001, "BS6", "Mahindra", "Bh23982", "scorpio", CarType.SPORT, 1000, user2);
        Car car3 = carRent.addCar(2001, "BS6", "Mahindra", "Bh23982", "saria", CarType.SPORT, 1000, user3);
        Car car4 = carRent.addCar(2001, "BS6", "Mahindra", "Bh23982", "bullero", CarType.XUV, 1000, user3);
        Car car5 = carRent.addCar(2001, "BS6", "Tata", "Bh23982", "nexon", CarType.LUXURY, 1000, user3);
        Car car6 = carRent.addCar(2001, "BS6", "Tata", "Bh23982", "punch", CarType.XUV, 1000, user2);
        Car car7 = carRent.addCar(2001, "BS6", "Mahindra", "Bh23982", "thar", CarType.SPORT, 1000, user2);
        
        Payment carPayment = new CreditCardPayment();
        Payment upiPayment = new UPIPayment();
        carRent.addPaymentOption(PaymentType.CREDITCART, carPayment);
        carRent.addPaymentOption(PaymentType.UPI, upiPayment);

        LocalDate startDate = LocalDate.now().plusDays(5);
        LocalDate endDate = LocalDate.now().plusDays(10);
        List<Car> cars = carRent.browse(CarType.XUV, null, startDate, endDate, 0, 0);
        System.out.println("Search result: "+ cars);


        Invoice invoice1 = carRent.book(car1, startDate ,endDate, 100, user2, PaymentType.CREDITCART);
        invoice1 = carRent.book(car1, startDate, endDate, 1000, user2, PaymentType.UPI);

    }


}
