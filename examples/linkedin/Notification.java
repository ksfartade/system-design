package linkedin;

public class Notification {
    String message;
    NotificationType notificationType;
    boolean read = false;
    public Notification(String message, NotificationType notificationType) {
        this.message = message;
        this.notificationType = notificationType;
    }

    public void markRead(){
        this.read = true;
    }

    public String getMessage() {
        return message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public boolean isRead() {
        return read;
    }
}
