package coffevendingmachine.states;

import coffevendingmachine.coffetypes.BaseCoffee;

public interface CoffeeState {
    void selectItem(BaseCoffee coffee);
    void receivePayment(int amount);
    void createCoffee(BaseCoffee coffee);
    int collectChange();

}
