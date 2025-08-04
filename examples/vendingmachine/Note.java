package vendingmachine;

public enum Note {
    TEN(10), FIFTY(50), HUNDRED(100) ;

    private int value;

    Note(int value){
        this.value = value ;
    }

    public int getValue(){
        return this.value;
    }
}
