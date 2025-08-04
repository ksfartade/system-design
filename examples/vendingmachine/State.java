package vendingmachine;

public interface State {
    public void insertCoin(Coin coin);
    public void insertNote(Note note);
    public void selectProduct(Product product, int count);
    public void despense();
    public void processReturn();
}
