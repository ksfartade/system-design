package trafficsignal.signals;

import trafficsignal.Color;
import trafficsignal.Sleep;

public class Lane1 implements Signal {
    private static final Lane1 instance = new Lane1();
    private static Signal nextLane = Lane2.getInstance();
    public static Lane1 getInstance(){
        return instance;
    }

    private static int greenTime, orangeTime, pausedTime;
    private Color currentColor, pausedColor ;
    
    @Override
    public void start(int greenTime, int orangeTime) {
        currentColor = Color.GREEN;
        System.out.println("Green will be for: " + greenTime);
        Sleep.sleep(800);
        currentColor = Color.ORANGE;
        System.out.println("Orange will be for: " + orangeTime);
        Sleep.sleep(200);
        currentColor = Color.RED;

        nextLane.execute();
    }

    @Override
    public void execute(){
        System.out.println("At Signal 1: ");
        this.start(Lane1.greenTime, Lane1.orangeTime);
    }

    @Override
    public void pause(int time) {
        pausedColor = currentColor;
        currentColor = Color.RED;
        pausedTime = time;
    }

    @Override
    public void resume() {
        currentColor = pausedColor;
        if(pausedColor == Color.GREEN){
            start(greenTime-pausedTime, orangeTime);
        }
        start(0, orangeTime-pausedTime);
    }

    public static void setGreenTime(int greenTime) {
        Lane1.greenTime = greenTime;
    }

    public static void setOrangeTime(int orangeTime) {
        Lane1.orangeTime = orangeTime;
    }
    
}
