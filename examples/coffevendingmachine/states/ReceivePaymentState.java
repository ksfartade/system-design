package coffevendingmachine.states;

import coffevendingmachine.VendingMachine;
import coffevendingmachine.coffetypes.BaseCoffee;

public class ReceivePaymentState implements CoffeeState  {
    private static ReceivePaymentState instance = new ReceivePaymentState();

    public static ReceivePaymentState getInstance(){
        return instance;
    }

    @Override
    public void selectItem(BaseCoffee coffee) {
        System.out.println("Item already selected...");
    }

    @Override
    public void receivePayment(int amount) {
        if(amount < VendingMachine.selectedCoffee.getPrice()){
            System.out.println("Please enter more amount...");
            return ;
        }

        VendingMachine.receivePayment = amount;
        System.out.println("Payment received successfully. I am creating a coffee for you...");
        VendingMachine.currentState = CreateCoffeeState.getInstance();
    }

    @Override
    public void createCoffee(BaseCoffee coffee) {
        System.out.println("Please pay amount first...");
    }

    @Override
    public int collectChange() {
        System.out.println("Please pay amount first..");
        return 0;
    }
    
}
