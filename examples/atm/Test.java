package atm;

public class Test {
    public static void main(String[] args) {
        ATM atm = ATM.getInstance();
        atm.setup(100000);
        
        Card card = new Card("12323", "232334", "a;lskdfj");
        atm.insertCard(card);

        atm.enterPin(12312);

        atm.checkBalance(card);

        atm.enterAmount(10000000);

        atm.enterAmount(1000);

        atm.despense();

    }
}
