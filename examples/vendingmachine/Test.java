package vendingmachine;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Product, Integer> map = new HashMap<>();
        Product chips = new Product("Banana Chips", 10);
        Product dairyMilk = new Product("Dairy Milk", 10);

        map.put(chips, 5);
        map.put(dairyMilk, 5);

        Store store = new Store(map);

        VendingMachine vendingMachine = VendingMachine.getInstance(store);
        vendingMachine.store = store;
        
        // User start using...
        System.out.println("Selecting 2 Daily milks..");
        try {
            Thread.sleep(2000); // Pause for 2 seconds (2000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vendingMachine.selectProduct(dairyMilk, 1);

        System.out.println("Entering amount..");
        try {
            Thread.sleep(2000); // Pause for 2 seconds (2000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vendingMachine.insertCoin(Coin.FIVE);
        vendingMachine.insertCoin(Coin.FIVE);

        vendingMachine.despenseProduct();

    }
}
