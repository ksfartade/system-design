package vendingmachine;

public enum Coin {
    ONE(1), TWO(3), FIVE(5); 

    private int value;

    Coin(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
