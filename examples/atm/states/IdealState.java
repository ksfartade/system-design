package atm.states;

import atm.ATM;
import atm.BankAPI;
import atm.Card;

public class IdealState implements State{
    private static final IdealState idealState = new IdealState();
    private static ATM atm;
    public static IdealState getInstance(){
        atm = ATM.getInstance();
        return idealState;
    }


    @Override
    public void insertCard(Card card) {
        if(BankAPI.validateCard(card)){
            System.out.println("Validation successfull");
            atm.setEnterPinState();
        }
        else{
            System.out.println("Invalid card..");
        }
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Please your card first...");
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
        System.out.println("Insert your card first..");
        return 0;
    }
    
}
