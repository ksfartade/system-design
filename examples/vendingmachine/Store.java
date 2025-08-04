package vendingmachine;

import java.util.HashMap;

public class Store {
    HashMap<Product, Integer> map = new HashMap<>();

    public Store(HashMap<Product, Integer> map) {
        this.map = map;
    }

    public void addProduct(Product product, int count){
        map.put(product, map.getOrDefault(product, 0) + count);
        System.out.println("Product added in store successfully");
    }

    public boolean check(Product product, int count){
        return map.get(product) >= count ;
    }

    public void removeProduct(Product product, int count){
        map.put(product, map.getOrDefault(product, 0) - count);
    }
}
