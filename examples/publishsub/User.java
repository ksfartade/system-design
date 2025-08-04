package publishsub;
import java.util.*;

public class User implements BaseUser{
    int id;
    String userName;
    List<Message> messages;

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
        messages = new ArrayList<>();
    }

    @Override
    public void broadCast(Message message) {
        System.out.println("Received message: " + message.text + " to the user: " + userName);
    }
    
}
