package carrentalsystem.payment;

import carrentalsystem.Sleep;

public class UPIPayment implements Payment{
    PaymentType paymentType = PaymentType.UPI;
    
    @Override
    public boolean makePayment(int amount) {
        System.out.println("Making UPI payment please wait...");
        Sleep.sleep(1000);
        return true;
    }
    
}
