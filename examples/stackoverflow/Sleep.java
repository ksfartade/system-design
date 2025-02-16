package stackoverflow;

public class Sleep {
    public static void sleep(int time){
        try {
            Thread.sleep(time * 1000); // Pause for 2 seconds (2000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
