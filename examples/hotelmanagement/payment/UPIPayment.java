package hotelmanagement.payment;

import atm.Sleep;

public class UPIPayment  implements Payment{
    PaymentType paymentType = PaymentType.UPI;

    private static Payment instance = new UPIPayment();

    public static Payment getInstance(){
        return instance;
    }

    @Override
    public boolean process(int amount) {
        System.out.println("Processing UPI payment...");
        Sleep.sleep(1000);
        System.out.println("Payment received successfully..");
        return true;
    }
}
