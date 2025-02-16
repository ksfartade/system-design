package loggingframework.loglevels;

import loggingframework.LogMessage;
import loggingframework.LogType;
import loggingframework.Sleep;

public class FatalLog implements LogLevel {
    LogType logType = LogType.ERROR ;
    private static final FatalLog instance = new FatalLog();

    public String formatLog(LogMessage logMsg){
        // we can add formatting styles here for this type of log messages.
        String formattedLog = logMsg + " \n Kind Note: Resolve those exceptions as early as possible to improve your experience..";
        Sleep.sleep(0.5);
        System.out.println("Fatal log formatted successfully.." + formattedLog);
        return formattedLog;
    }

    public static FatalLog getInstance(){
        return instance;
    }
}
