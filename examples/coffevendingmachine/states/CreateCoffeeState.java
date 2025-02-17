package coffevendingmachine.states;

import coffevendingmachine.Sleep;
import coffevendingmachine.VendingMachine;
import coffevendingmachine.coffetypes.BaseCoffee;

public class CreateCoffeeState implements CoffeeState {
    private static CreateCoffeeState instance = new CreateCoffeeState();

    public static CreateCoffeeState getInstance(){
        return instance;
    }

    @Override
    public void selectItem(BaseCoffee coffee) {
        System.out.println("Item already selected.. Now coffee is being created.");
    }

    @Override
    public void receivePayment(int amount) {
        System.out.println("Payment already received. Now coffee is being created..");
    }

    @Override
    public void createCoffee(BaseCoffee coffee) {
        System.out.println("Creating your beloved coffee. Please wait...");
        Sleep.sleep(1);
        coffee.create();
        System.out.println("You coffee is ready please collect your coffee.");
        VendingMachine.currentState = CollectChangeState.getInstance();
    }

    @Override
    public int collectChange() {
        System.out.println("Wait till creating coffee.");
        return 0;
    }

}
