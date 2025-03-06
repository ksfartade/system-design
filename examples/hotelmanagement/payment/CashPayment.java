package hotelmanagement.payment;

import atm.Sleep;

public class CashPayment  implements Payment{
    PaymentType paymentType = PaymentType.CASH;

    private static Payment instance = new CashPayment();

    public static Payment getInstance(){
        return instance;
    }
    
    @Override
    public boolean process(int amount) {
        System.out.println("Processing cash payment...");
        Sleep.sleep(1000);
        System.out.println("Payment received successfully..");
        return true;
    }
}
