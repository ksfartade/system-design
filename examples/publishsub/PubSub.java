package publishsub;
import java.util.*;


public class PubSub {
    Map<Integer, Message> messages = new HashMap<>();
    Map<Integer, User> users = new HashMap<>();
    Map<String, Topic> topics = new HashMap<>();
    int userId = 0, MsgId = 0, topicId = 0;

    private static PubSub instance = new PubSub();

    public synchronized static PubSub getInstance(){
        return instance;
    }

    public synchronized User addUser(String userName){
        User user = new User(++userId, userName);
        System.out.println("User created successfully");
        return user;
    }

    public Topic createTopic(String name, User author){
        Topic topic = new Topic(name, MsgId, author);
        topics.put(name, topic);
        System.out.println("Topic created successfully..");
        return topic;
    }

    public synchronized Message addMessage(User author, String text, List<String> topicNames){
        Message message = new Message(author, text, ++MsgId);
        messages.put(MsgId, message);
        for(String topicName: topicNames){
            Topic topic = topics.get(topicName);
            topic.broadCast(message);
            message.topics.add(topic);
        }
        System.out.println("Message created successfully..");

        return message;
    }

    public Topic subscribe(User user, Topic topic){
        topic.subscribers.add(user);
        System.out.println("User " + user.userName + " subscribed to the topic " + topic.name);
        return topic;
    }
}
