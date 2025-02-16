package loggingframework.loglevels;

import loggingframework.LogMessage;
import loggingframework.LogType;
import loggingframework.Sleep;

public class ErrorLog implements LogLevel {
    LogType logType = LogType.ERROR ;

    @Override
    public String formatLog(LogMessage logMsg){
        // we can add formatting styles here for this type of log messages.
        String formattedLog = logMsg.toString();
        Sleep.sleep(0.5);
        System.out.println("Error log formatted successfully..");
        return formattedLog;
    }

    private static LogLevel instance ;
    public static LogLevel getInstance(){
        if(instance == null){
            instance = new ErrorLog();
        }
        return instance;
    }
}
