package atm.states;

import atm.Card;

public interface State {
    public void insertCard(Card Card);
    public void enterPin(int pin);
    public int checkBalance(Card card);
    public void enterAmount(int amount);
    public void dispenseCash();
}
