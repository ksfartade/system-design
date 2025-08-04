package carrentalsystem;

import java.time.LocalDate;
import java.util.HashSet;

public class Car {
    int year, price, id;
    String model, company, number, name;
    CarType carType;
    User owner;
    HashSet<Invoice> invoices;
    public Car(int id, int year, String model, String company, String number, String name, CarType carType, int price, User owner) {
        this.id = id;
        this.year = year;
        this.model = model;
        this.company = company;
        this.number = number;
        this.name = name;
        this.carType = carType;
        this.price = price;
        this.owner = owner;
        invoices = new HashSet<>();
    }

    public Invoice book(LocalDate startDate, LocalDate endDate, User user){
        if(isAvailable(startDate, endDate)){
            System.out.println("Booked successfully..");
            Invoice invoice = new Invoice(user, price, this, startDate, endDate );
            invoices.add(invoice);
            return invoice;
        }
        System.out.println("Car is not empty for this date...");
        return null;
    }

    public boolean cancel(Invoice invoice){
        if(invoices.remove(invoice)){
            System.out.println("Your order cancelled successfully. You will receive your refund in 10 days.");
            return true ;
        }
        System.out.println("Order could not found.");
        return false;
    }

    public Invoice update(Invoice invoice, LocalDate startDate, LocalDate endDate){
        if(isAvailable(startDate, endDate)){
            System.out.println("updated successsfully...");
            invoice.startDate = startDate;
            invoice.endDate = endDate;
            return invoice;
        }
        System.out.println("Requested date is not available... Please select another date..");
        return null;
    }


    public boolean isAvailable(LocalDate startDate, LocalDate endDate){
        for(Invoice invoice: invoices){
            if((invoice.startDate.isBefore(startDate) && invoice.endDate.isAfter(startDate)) || (invoice.startDate.isBefore(endDate) && invoice.endDate.isAfter(endDate))){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return this.carType + " Number: " + this.number + " Price: " + this.price;
    }
    
}
