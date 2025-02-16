package loggingframework;

import java.util.*;

import loggingframework.formatter.Formatter;
import loggingframework.loglevels.LogLevel;
import loggingframework.loglevels.LogLevelFactory;

public class Logging {
    LogType logType ;
    List<Formatter> formatters;

    public static final Logging instance = new Logging();

    public static Logging getInstance(){
        return instance;
    }

    public void logMsg(String msg, LogType logType){
        if(logType.getLevel() < this.logType.getLevel()){
            System.out.println("Can't not log message of this level");
            return ;
        }

        LogLevel logLevel = LogLevelFactory.getLogLevel(logType);
        LogMessage logMessage = new LogMessage(msg, logType);
        String formattedLog = logLevel.formatLog(logMessage);

        for(Formatter formatter: formatters){
            formatter.format(formattedLog);
        }
    }
}
