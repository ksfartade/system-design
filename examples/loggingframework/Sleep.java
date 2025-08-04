package loggingframework;

public class Sleep {
    public static void sleep(double time){
        try {
            Thread.sleep((int)(time * 1000)); // Pause for 2 seconds (2000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
