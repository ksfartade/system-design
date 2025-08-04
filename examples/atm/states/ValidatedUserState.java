package atm.states;

import atm.ATM;
import atm.BankAPI;
import atm.Card;

public class ValidatedUserState implements State{
    private static final ValidatedUserState validatedUserState = new ValidatedUserState();
    private static ATM atm;
    private static int storedAmount;


    public static ValidatedUserState getInstance(int storedAmount){
        atm = ATM.getInstance();
        ValidatedUserState.storedAmount = storedAmount;
        return validatedUserState;
    }


    @Override
    public void insertCard(Card card) {
        System.out.println("Card already accepted. Please enter amount or press reset to cancel.");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Pin already validated. Please enter amount or press reset to cancel.");
    }

    @Override
    public void enterAmount(int amount) {
        if(amount > storedAmount){
            System.out.println("Low cash. Please enter lower amount...");
            return;
        }

        if(BankAPI.validateAmount(atm.card, amount)){
            System.out.println("Amount received successfully..");
            atm.setSetDespenseState();
            return;
        }

        System.out.println("Insufficient amount...");
    }

    @Override
    public void dispenseCash() {
        System.out.println("Please enter amount first...");
    }

    @Override
    public int checkBalance(Card card) {
        int balance = BankAPI.checkBalance(card);
        return balance;
    }
    
}
