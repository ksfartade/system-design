package trafficsignal;

public class LambdaThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i = 0; i< 10; i++){
                System.out.println("T1 " + i);
            }
        } );
        
        t1.start();

        Thread t2 = new Thread(() -> {
            for(int i = 0; i< 10; i++){
                System.out.println("T2 " + i);
            }
        } );
        
        t2.start();
    }
}
