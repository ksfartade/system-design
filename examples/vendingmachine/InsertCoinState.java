package vendingmachine;

public class InsertCoinState implements State {

    private VendingMachine vendingMachine;

    public InsertCoinState(){
        this.vendingMachine = VendingMachine.getInstance(null);
    }

    @Override
    public void insertCoin(Coin coin) {
        if(completeAmount(coin.getValue())){
            System.out.println("Received complete amount. Dispensing product...");
            vendingMachine.setDispenseState();
        }
        System.out.println("Amount received, please enter more amount...");
    }

    @Override
    public void insertNote(Note note) {
        if(completeAmount(note.getValue())){
            System.out.println("Received complete amount. Dispensing product...");
            vendingMachine.setDispenseState();
        }
        System.out.println("Amount received, please enter more amount...");

    }

    @Override
    public void selectProduct(Product product, int count) {
        System.out.println("Product already selected.... Please enter amount...");
    }

    @Override
    public void despense() {
        System.out.println("Please enter complete amount first...");
    }

    @Override
    public void processReturn() {
        System.out.println("Complete amount not received.");
    }

    private boolean completeAmount(int amount){
        vendingMachine.receivedPayment += amount;
        if(vendingMachine.receivedPayment >= vendingMachine.getProductValue()){
            return true;
        }
        return false;
    }
    
}
