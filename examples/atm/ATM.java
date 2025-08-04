package atm;

import atm.states.DespenseCashState;
import atm.states.EnterPinState;
import atm.states.IdealState;
import atm.states.State;
import atm.states.ValidatedUserState;

public class ATM {
    private static ATM atm = new ATM();
    
    public static ATM getInstance(){
        return atm;
    }

    private State idealState ;
    private State enterPinState ;
    private State validatedUserState ;
    private State despenseState ;
    private State currState;

    public void setup(int storedAmount){
        idealState = IdealState.getInstance();
        enterPinState = EnterPinState.getInstance();
        validatedUserState = ValidatedUserState.getInstance(storedAmount);
        despenseState = DespenseCashState.getInstance();
        currState = idealState;
    }
    

    public Card card;
    public int amount;

    public void setEnterPinState(){
        System.out.println("Your are in enter pin state..");
        currState = enterPinState;
    }

    public void setValidatedUserState(){
        System.out.println("Your are in validated user state. You can check balance or withdraw...");
        currState = validatedUserState;
    }

    public void setSetDespenseState(){
        System.out.println("Dispensing your amount...");
        currState = despenseState;
    }

    public void reset(){
        System.out.println("Cancelling flow and resetting..");
        Sleep.sleep(500);
        currState = idealState;
    }

    public void setIdealState() {
        currState = idealState;
    }

    public void insertCard(Card card){
        this.card = card;
        currState.insertCard(card);
    }

    public void enterPin(int pin){
        currState.enterPin(pin);
    }
    
    public void enterAmount(int amount){
        this.amount = amount;
        currState.enterAmount(amount);
    }

    public void despense(){
        currState.dispenseCash();
    }

    public void checkBalance(Card card){
        int balance = currState.checkBalance(card);
        System.out.println("Your account balance is: " + balance);
    }

}
