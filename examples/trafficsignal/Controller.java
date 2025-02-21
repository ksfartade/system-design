package trafficsignal;

import trafficsignal.signals.Lane1;
import trafficsignal.signals.Lane2;
import trafficsignal.signals.Lane3;
import trafficsignal.signals.Lane4;
import trafficsignal.signals.Signal;

public class Controller {
    private static final Controller instance = new Controller();
    static Signal currentSignal = Lane1.getInstance();

    public static Controller getInstance(){
        return instance;
    }

    public void configure(){
        Lane1.setGreenTime(60);
        Lane1.setOrangeTime(30);

        Lane2.setGreenTime(100);
        Lane2.setOrangeTime(100);

        Lane3.setGreenTime(100);
        Lane3.setOrangeTime(100);

        Lane4.setGreenTime(100);
        Lane4.setOrangeTime(100);
    }


    public void start(){
        System.out.println("Execution started...");
        currentSignal.execute();
    }

    public void emergency(Signal signal){
        System.out.println("Pausing current signal");
        currentSignal.pause(40);
        
        System.out.println("Starting emergency signal...");
        signal.start(1000, 10);
        System.out.println("Stopping emergency signal and resuming flow..");
        currentSignal.resume();
    }
}
