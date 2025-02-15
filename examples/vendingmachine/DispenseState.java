package vendingmachine;

public class DispenseState implements State {
    private VendingMachine vendingMachine;

    public DispenseState(){
        this.vendingMachine = VendingMachine.getInstance(null);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Payment already received. Dispensing product..");
    }

    @Override
    public void insertNote(Note note) {
        System.out.println("Payment already received. Dispensing product...");
    }

    @Override
    public void selectProduct(Product product, int count) {
        System.out.println("Product already selected. Dispensing product...");
    }

    @Override
    public void despense() {
        vendingMachine.store.removeProduct(vendingMachine.selectecteProduct, vendingMachine.selectedCount);
        vendingMachine.setProcessReturnState();
    }

    @Override
    public void processReturn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processReturn'");
    }

}
