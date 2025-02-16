package loggingframework.loglevels;

import loggingframework.LogMessage;
import loggingframework.LogType;
import loggingframework.Sleep;

public class DebugLog implements LogLevel {
    LogType logType = LogType.DEBUG ;

    @Override
    public String formatLog(LogMessage logMsg){
        // we can add formatting styles here for this type of log messages.
        String formattedLog = logMsg.toString() + " Don't log sensitive information..";
        Sleep.sleep(0.5);
        System.out.println("Debug log formatted successfully.." + formattedLog);
        return formattedLog;
    }

    private static LogLevel instance ;
    public static LogLevel getInstance(){
        if(instance == null){
            instance = new DebugLog();
        }
        return instance;
    }
}
