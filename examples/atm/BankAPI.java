package atm;

public class BankAPI {
    public static boolean validateCard(Card card){
        System.out.println("Validating card details...");
        Sleep.sleep(1000);
        System.out.println("successfull validation...");
        return true;
    }

    public static boolean validatePin(Card card, int pin){
        System.out.println("Validating pin...");
        Sleep.sleep(1000);
        return true;
    }

    public static boolean validateAmount(Card card, int amount){
        System.out.println("Checking back balance...");
        Sleep.sleep(1000);
        return true;
    }

    public static int checkBalance(Card card) {
        System.out.println("Fetching bank balance. Please wait...");
        Sleep.sleep(1000);
        return 10000;
    }

    public static boolean debit(Card card, int amount) {
        System.out.println("Debiting API call in progress");
        Sleep.sleep(1000);
        return true;
    }
}
