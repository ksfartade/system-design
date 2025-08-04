package coffevendingmachine;

import coffevendingmachine.states.CoffeeState;
// import coffevendingmachine.states.CollectChangeState;
// import coffevendingmachine.states.CreateCoffeeState;
import coffevendingmachine.states.IdealState;
// import coffevendingmachine.states.ReceivePaymentState;
import coffevendingmachine.coffetypes.BaseCoffee; 
import java.util.*;

public class VendingMachine {
    public static CoffeeState currentState ;
    public List<BaseCoffee> coffees;
    public static BaseCoffee selectedCoffee;
    public static int receivePayment;

    private static VendingMachine instance = new VendingMachine();

    public static VendingMachine getInstance(){
        currentState = IdealState.getInstance();
        return instance;
    }

    public synchronized void selectItem(BaseCoffee coffee){
        currentState.selectItem(coffee);
    }

    public synchronized void makePayment(int receivedAmount){
        System.out.println("Please make payment with QR code or enter cash");
        Sleep.sleep(1000);
        currentState.receivePayment(receivedAmount);
    }

    public synchronized void createCoffee(){
        currentState.createCoffee(selectedCoffee);
    }

    public synchronized int collectChange(){
        return currentState.collectChange();
    }

    public List<BaseCoffee> availablCoffees(){
        return coffees;
    }
}
