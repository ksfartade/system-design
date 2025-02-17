package coffevendingmachine.coffetypes;

import coffevendingmachine.Sleep;

public class Type2 implements BaseCoffee {
    
    int sugar, milk, coffee;
    String name;
    
    public static Type2 instance = new Type2("type2", 10, 10, 10);

    private Type2(String name, int sugar, int milk, int coffee) {
        this.name = name;
        this.sugar = sugar;
        this.milk = milk;
        this.coffee = coffee;
    }

    public static Type2 getInstance(){
        return instance;
    }

    @Override
    public void create() {
        System.out.println("Please wait we are creating your lovely coffee...");
        Sleep.sleep(1000);
    }

    @Override
    public int getPrice() {
        return 50;
    }
    
}
