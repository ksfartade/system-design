package publishsub;
import java.util.*;

public class Topic {
    List<User> subscribers;
    List<Message> messages;
    String name;
    User author;
    int id;
    public Topic(String name, int id, User author) {
        this.name = name;
        subscribers = new ArrayList<>();
        messages = new ArrayList<>();
        this.id = id;
        this.author = author;
    }

    public void broadCast(Message message){
        for(User user: subscribers){
            user.broadCast(message);
        }
    }
}
