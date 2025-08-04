package atm.states;

import atm.ATM;
import atm.BankAPI;
import atm.Card;
import atm.Sleep;

public class DespenseCashState implements State{
    private static final DespenseCashState despenseCashState = new DespenseCashState();
    private static ATM atm;

    public static DespenseCashState getInstance(){
        atm = ATM.getInstance();
        return despenseCashState;
    }


    @Override
    public void insertCard(Card card) {
        System.out.println("Card already accepted. Please wait while despensing your cash..");
    }

    @Override
    public void enterPin(int pin) {
        System.out.println("Pin already validated. Please wait while cash despensing is in process.");
    }

    @Override
    public void enterAmount(int amount) {
        System.out.println("Amount already entered. Despensing cash..");
    }

    @Override
    public void dispenseCash() {
        boolean debit = BankAPI.debit(atm.card, atm.amount);
        if(!debit){
            System.out.println("Your bank server is currently not available.. Please try again..");
            atm.setIdealState();
            return;
        }

        System.out.println("Please wait while we are depensing your cash...");
        Sleep.sleep(1000);
        System.out.println("Please collect your cash..");
        atm.setIdealState();
    }

    @Override
    public int checkBalance(Card card) {
        System.out.println("Despensing cash...");
        return 0;
    }
    
}
