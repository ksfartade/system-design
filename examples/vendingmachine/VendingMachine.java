package vendingmachine;

public class VendingMachine {
    private static IdealState idealState;
    private static InsertCoinState insertCoinState;
    private static DispenseState dispenseState;
    private static ReturnCashState returnCashState;
    private static State currState ;
    Store store;
    int receivedPayment ;

    Product selectecteProduct;
    int selectedCount ;

    public static VendingMachine vendingMachine;

    public static VendingMachine getInstance(Store store){
        if(vendingMachine == null){
            vendingMachine = new VendingMachine();
            idealState = new IdealState();
            insertCoinState = new InsertCoinState();
            dispenseState = new DispenseState();
            returnCashState = new ReturnCashState();
            currState = idealState;
            // selectecteProduct = null;
            // selectedCount = 0;
        }
        return vendingMachine;
    }

    // User actions...
    public void reset(){
        this.currState = idealState;
    }

    public void selectProduct(Product product, int count){
        currState.selectProduct(product, count);
    }

    public void insertCoin(Coin coin){
        currState.insertCoin(coin);
    }

    public void insertNote(Note note){
        currState.insertNote(note);
    }

    public void despenseProduct(){
        currState.despense();
    }


    // State change methods.
    public void setInsertCoinState(){
        currState = insertCoinState;
    }

    public void setDispenseState(){
        currState = dispenseState;
    }

    public void setProcessReturnState(){
        currState = returnCashState;
    }

    
    // Custom supporting methods.
    public int getProductValue(){
        return selectecteProduct.price * selectedCount;
    }

    public boolean checkAvailabilty(Product product, int count){
        return store.check(product, count);
    }
    
}
