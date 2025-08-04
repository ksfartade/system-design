package vendingmachine;

public class ReturnCashState implements State {
    private VendingMachine vendingMachine;

    public ReturnCashState(){
        this.vendingMachine = VendingMachine.getInstance(null);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already received..");
    }

    @Override
    public void selectProduct(Product product, int count) {
        System.out.println("Products already selected...");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already received...");        
    }

    @Override
    public void despense() {
        System.out.println("Product already dispensed...");
    }

    @Override
    public void processReturn() {
        System.out.println("Please collect your remaining amount....");
        vendingMachine.reset();
    }
    
}
