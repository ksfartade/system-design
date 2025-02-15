package vendingmachine;

public class IdealState implements State {
    private VendingMachine vendingMachine;

    public IdealState(){
        this.vendingMachine = VendingMachine.getInstance(null);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select product first..");
    }

    @Override
    public void selectProduct(Product product, int count) {
        if(vendingMachine.checkAvailabilty(product, count)){
            vendingMachine.selectecteProduct = product;
            vendingMachine.selectedCount = count;
            vendingMachine.setInsertCoinState();
        }
        else{
            System.out.println("Product not availabe...");
        }
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Please select product first...");        
    }

    @Override
    public void despense() {
        System.out.println("Please select product first...");
    }

    @Override
    public void processReturn() {
        System.out.println("Please enter product first...");
    }

}
