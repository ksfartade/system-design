package loggingframework.formatter;

import loggingframework.Sleep;

public class FileFormatter implements Formatter {

    @Override
    public void format(String log) {
        System.out.println("Saving log to file " + log);
        Sleep.sleep(1);
    }
}
