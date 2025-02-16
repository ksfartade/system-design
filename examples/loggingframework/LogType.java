package loggingframework;

public enum LogType {
    INFO(1), DEBUG(0), ERROR(2), FATAL(3) ;

    private int level ;
    
    LogType(int level){
        this.level = level;
    }
    
    public int getLevel() {
        return level;
    }
}
