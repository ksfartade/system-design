package carrentalsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import carrentalsystem.payment.Payment;
import carrentalsystem.payment.PaymentType;
import coffevendingmachine.Sleep;

public class CarRent {
    private static CarRent instance = new CarRent();
    public static CarRent getInstance(){
        return instance;
    }

    private final Map<PaymentType, Payment> availablePayments = new ConcurrentHashMap<>();

    private final Map<Integer, Car> cars = new ConcurrentHashMap<>();
    private int carId = 0;
    private int userId = 0;

    public void addPaymentOption(PaymentType paymentType, Payment payment){
        availablePayments.put(paymentType, payment);
        Sleep.sleep(500);
        System.out.println("Payment option added successfully...");
    }

    public User addUser(String name, String license, String contact){
        User user = new User(name, ++userId, license, contact);
        System.out.println("User added succesffully...");
        return user;
    }

    public Car addCar(int year, String model, String company, String number, String name, CarType carType, int price, User owner){
        Car car = new Car(++carId, year, model, company, number, name, carType, price, owner);
        cars.put(carId, car);
        System.out.println("Car added successfully...");
        return car;
    }

    public Car editCar(int carId, int year, String model, String company, String number, CarType carType, int price, User user){
        Car car = cars.get(carId);
        if(car.owner != user){
            System.out.println("You don't have permission to edit this car details...");
        }
        car.year = year;
        car.model = model;
        car.company = company;
        car.number = number;
        car.carType = carType;
        car.price = price;
        car.owner = user;
        System.out.println("Car details updated successfully...");
        return car;
    }

    public boolean removeCar(int carId, User user){
        Car car = cars.get(carId);
        if(car.owner != user){
            System.out.println("You don't have permission to remove this car..");
        }
        cars.remove(carId);
        System.out.println("Car removed successfully..");
        return true;
    }

    public List<Car> browse(CarType carType, String carName, LocalDate startDate, LocalDate endDate, int minPrice, int maxPrice){
        System.out.println("Searching... just wait..");
        List<Car> result = new ArrayList<>();
        for(Car car: cars.values()){
            if(car.carType == carType){
                result.add(car);
            }
            else if(maxPrice > 0 && car.price >= minPrice && car.price <= maxPrice){
                result.add(car);
            }
            else if(startDate != null){
                if(car.isAvailable(startDate, endDate)){
                    result.add(car);
                }
            }
        }
        Sleep.sleep(1000);
        return result;
    }

    public boolean isAvailable(Car car, LocalDate starDate, LocalDate enDate){
        return car.isAvailable(starDate, enDate);
    }

    public synchronized Invoice book(Car car, LocalDate starDate, LocalDate enDate, int amount, User user, PaymentType paymentType){
        System.out.println("Booking...");
        Sleep.sleep(500);
        if(car.price > amount){
            System.out.println("Insufficient amount...");
            return null;
        }
        if(!isAvailable(car, starDate, enDate)){
            System.out.println("Car not available for selected date...");
            return null;
        }
        if(!makePayment(paymentType, amount)){
            System.out.println("Payment failed...");
            return null;
        }
        Invoice invoice = car.book(starDate, enDate, user);
        return invoice;
    }
    
    public boolean makePayment(PaymentType paymentType, int amount){
        Payment payment = availablePayments.get(paymentType);
        System.out.println("Processing payment..");
        if(!payment.makePayment(amount)){
            System.out.println("Insufficient amount...");
            return false;
        }
        System.out.println("Successfull payment..");
        return true;
    }

    public synchronized Invoice updateBooking(Invoice invoice, Car newCar, LocalDate starDate, LocalDate enDate, User user, int amount, PaymentType paymentType){
        System.out.println("Updating....");
        Sleep.sleep(500);
        if(!newCar.isAvailable(starDate, enDate)){
            System.out.println("Car not available on selected date..");
            return null;
        }

        if(!makePayment(paymentType, amount + invoice.amountPaid)){
            return null;
        }

        invoice.car.cancel(invoice);
        return newCar.book(starDate, enDate, user);
    }

    public synchronized void cancelBooking(Invoice invoice){
        System.out.println("Canceling.. Please wait..");
        Sleep.sleep(500);
        invoice.car.cancel(invoice);
        System.out.println("Cancelled successfully..");
    }

}
