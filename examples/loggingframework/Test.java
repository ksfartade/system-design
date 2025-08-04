package loggingframework;
import java.util.*;

import loggingframework.formatter.ConsoleFormatter;
import loggingframework.formatter.FileFormatter;
import loggingframework.formatter.Formatter;

public class Test {
    public static void main(String[] args) {
        List<Formatter> formatters = new ArrayList<>();

        formatters.add(new ConsoleFormatter());
        formatters.add(new FileFormatter());

        Logging logging = Logging.getInstance();
        logging.formatters = formatters;
        logging.logType = LogType.INFO;

        logging.logMsg("Loading project", LogType.DEBUG);

        logging.logMsg("Entered into API successfully", LogType.INFO);

        logging.logMsg("divide by zero exception", LogType.FATAL);
    }
}
