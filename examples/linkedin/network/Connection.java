package linkedin.network;

import java.time.LocalDateTime;

import linkedin.User;

public class Connection {
    User sender, receiver;
    LocalDateTime time;
    ConnectionStatus status;

    public ConnectionStatus getStatus() {
        return status;
    }

    public Connection(User sender, User receiver, LocalDateTime time) {
        this.sender = sender;
        this.receiver = receiver;
        this.time = time;
        status = ConnectionStatus.NEW;
    }

    public User getSender() {
        return sender;
    }
    public User getReceiver() {
        return receiver;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void accept(){
        status = ConnectionStatus.ACCEPTED;
    }

    public void decline(){
        status = ConnectionStatus.DECLINED;
    }
    
}
