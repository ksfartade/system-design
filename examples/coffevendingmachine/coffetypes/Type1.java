package coffevendingmachine.coffetypes;

import coffevendingmachine.Sleep;

public class Type1 implements BaseCoffee  {
    int sugar, milk, coffee;
    String name;
    
    public static Type1 instance = new Type1("type1", 10, 10, 10);

    private Type1(String name, int sugar, int milk, int coffee) {
        this.name = name;
        this.sugar = sugar;
        this.milk = milk;
        this.coffee = coffee;
    }

    public static Type1 getInstance(){
        return instance;
    }

    @Override
    public void create() {
        System.out.println("Please wait we are creating your lovely coffee...");
        Sleep.sleep(1000);
    }

    @Override
    public int getPrice() {
        return 100;
    }
    
}
