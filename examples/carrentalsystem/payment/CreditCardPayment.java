package carrentalsystem.payment;

public class CreditCardPayment implements Payment{
    PaymentType paymentType = PaymentType.CREDITCART;
    
    @Override
    public boolean makePayment(int amount) {
        System.out.println("Making payment through credit card..");
        return true;
    }
    
}
