package trafficsignal.signals;

public interface Signal {
    void execute();
    void start(int greenTime, int orangeTime);
    void pause(int pausedTime);
    void resume();
}
