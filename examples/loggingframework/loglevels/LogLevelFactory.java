package loggingframework.loglevels;

import loggingframework.LogType;

public class LogLevelFactory {
    public static LogLevel getLogLevel(LogType logType){
        switch (logType) {
            case LogType.INFO:
                return InfoLog.getInstance();
            case LogType.DEBUG:
                return DebugLog.getInstance();
            case LogType.FATAL:
                return FatalLog.getInstance();
            default:
                return DebugLog.getInstance();
        }
    }
}
