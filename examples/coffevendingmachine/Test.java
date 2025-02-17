package coffevendingmachine;

import java.util.*;

import coffevendingmachine.coffetypes.BaseCoffee;
import coffevendingmachine.coffetypes.Type1;
import coffevendingmachine.coffetypes.Type2;

public class Test {
    public static void main(String[] args) {
        List<BaseCoffee> coffees = new ArrayList<>();
        coffees.add(Type1.getInstance());
        coffees.add(Type2.getInstance());

        VendingMachine vendingMachine = VendingMachine.getInstance();
        vendingMachine.coffees = coffees;

        vendingMachine.selectItem(Type1.getInstance());
        vendingMachine.createCoffee();

        vendingMachine.makePayment(10);
        vendingMachine.makePayment(100);
        vendingMachine.createCoffee();
    }
}
