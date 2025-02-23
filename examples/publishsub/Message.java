package publishsub;
import java.util.*;

public class Message {
    User author;
    String text;
    int id;
    List<Topic> topics ;
    public Message(User author, String text, int id) {
        this.author = author;
        this.text = text;
        this.id = id;
        topics = new ArrayList<>();
    }

    
}
