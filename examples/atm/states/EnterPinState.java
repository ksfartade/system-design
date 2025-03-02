package atm.states;

import atm.ATM;
import atm.BankAPI;
import atm.Card;

public class EnterPinState implements State{
    private static final EnterPinState enterPinState = new EnterPinState();
    private static ATM atm;

    public static EnterPinState getInstance(){
        atm = ATM.getInstance();
        return enterPinState;
    }


    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted. Please enter your pin or press reset..");
    }

    @Override
    public void enterPin(int pin) {
        if(BankAPI.validatePin(atm.card, pin)){
            System.out.println("Pin validation successfull");
            atm.setValidatedUserState();
        }
        else{
            System.out.println("Invalid pin.. Please try again..");
        }
    }

    @Override
    public void enterAmount(int amount) {
        System.out.println("Please enter card first..");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Please enter card first...");
    }

    @Override
    public int checkBalance(Card card) {
        System.out.println("Please enter pin first..");
        return 0;
    }
    
}
