package loggingframework;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogMessage {
    String message;
    LogType logType;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");;
    LocalTime now = LocalTime.now();

    public LogMessage(String message, LogType logType) {
        this.message = message;
        this.logType = logType;
    }

    @Override
    public String toString() {
        return "[" + logType + ", " + now.format(dateTimeFormatter) + " message=" + message + "]";
    }

    
}
