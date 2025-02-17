package coffevendingmachine.states;

import coffevendingmachine.Sleep;
import coffevendingmachine.VendingMachine;
import coffevendingmachine.coffetypes.BaseCoffee;

public class CollectChangeState implements CoffeeState {
    private static CollectChangeState instance = new CollectChangeState();

    public static CollectChangeState getInstance(){
        return instance;
    }

    @Override
    public void selectItem(BaseCoffee coffee) {
        System.out.println("Already selected..");
    }

    @Override
    public void receivePayment(int amount) {
        System.out.println("Payment already received..");
    }

    @Override
    public void createCoffee(BaseCoffee coffee) {
        System.out.println("Already created coffee..");
    }

    @Override
    public int collectChange() {
        int change = VendingMachine.selectedCoffee.getPrice() - VendingMachine.receivePayment;
        if(change > 0){
            System.out.println("Processing return. Please wait.");
            Sleep.sleep(500);
            System.out.println("Please collect your remaining amount..");
        }
        System.out.println("Nice to see you again. Hope you will enjoy this coffee..");
        VendingMachine.currentState = IdealState.getInstance();
        return change;        
    }
    
}
