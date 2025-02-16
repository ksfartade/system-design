package loggingframework.formatter;

import loggingframework.Sleep;

public class ConsoleFormatter implements Formatter {

    @Override
    public void format(String log) {
        System.out.println(log);
        Sleep.sleep(0.5);
    }
    
}
