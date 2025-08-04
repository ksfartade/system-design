package linkedin.message;

import java.time.LocalDateTime;

import linkedin.User;

public class Message {
    User user, to;
    String text;
    LocalDateTime time;
    MessageStatus status;

    
    public Message(User user, User to, String text, LocalDateTime time) {
        this.user = user;
        this.to = to;
        this.text = text;
        this.time = time;
        this.status = MessageStatus.NEW;
    }


    public User getUser() {
        return user;
    }


    public User getTo() {
        return to;
    }


    public String getText() {
        return text;
    }


    public LocalDateTime getTime() {
        return time;
    }

    public void markRead(){
        this.status = MessageStatus.READ;
    }


    public String toString(){
        return "From : " + user.getUserName() + " TO: " + to.getUserName() + " Message: " + text ;
    }


    
}
