package loggingframework.loglevels;

import loggingframework.LogMessage;

public interface LogLevel {
    public String formatLog(LogMessage msg);
}
