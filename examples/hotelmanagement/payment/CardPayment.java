package hotelmanagement.payment;

import atm.Sleep;

public class CardPayment implements Payment{
    PaymentType paymentType = PaymentType.CARD;

    private static Payment instance = new CardPayment();

    public static Payment getInstance(){
        return instance;
    }
    
    @Override
    public boolean process(int amount) {
        System.out.println("Processing card payment...");
        Sleep.sleep(1000);
        System.out.println("Payment received successfully..");
        return true;
    }
    
}
