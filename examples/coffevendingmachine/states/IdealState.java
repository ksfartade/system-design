package coffevendingmachine.states;

import coffevendingmachine.VendingMachine;
import coffevendingmachine.coffetypes.BaseCoffee;

public class IdealState implements CoffeeState {
    private static IdealState instance = new IdealState();

    public static IdealState getInstance(){
        return instance;
    }

    @Override
    public void selectItem(BaseCoffee coffee) {
        VendingMachine.selectedCoffee = coffee;
        System.out.println("Item selected successfully. Please make payment.");
        VendingMachine.currentState = ReceivePaymentState.getInstance();
    }

    @Override
    public void receivePayment(int amount) {
        System.out.println("Please select coffee first...");
    }


    @Override
    public void createCoffee(BaseCoffee coffee) {
        System.out.println("Please select coffee first.");
    }


    @Override
    public int collectChange() {
        System.out.println("Please select item first..");
        return 0;
    }
}
