package linkedin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import linkedin.message.Message;


public class MessageHandler {
    private static MessageHandler messageHandler = new MessageHandler();
    private NetworkHandler networkHandler = NetworkHandler.getInstance();
    List<Message> messages = new ArrayList<>();

    
    public static MessageHandler getInstance(){
        return messageHandler;
    }

    public Message sendMessage(User user, User to, String text){
        System.out.println("Sending message please wait...");
        Sleep.sleep(1000);

        if(!user.isLoggedIn()){
            System.out.println("User is not logged in..");
            return null;
        }
        if(networkHandler.checkConnection(user, to)){
            System.out.println("You can not send message. Please make connection first to send message");
            return null;
        }

        Message message = new Message(user, to, text, LocalDateTime.now());
        messages.add(message);
        System.out.println("Messsage sent successfully...");
        return message;
    }

    public List<Message> getAllMessages(User user, User to){
        System.out.println("Fetching messages please wait..");
        Sleep.sleep(1000);

        if(!user.isLoggedIn()){
            System.out.println("User is not logged in. Please log in first..");
            return null;
        }

        List<Message> list = new ArrayList<>();

        for(Message message: messages){
            if((message.getUser() == user || message.getTo() == user) && (message.getUser() == to || message.getTo() == to)){
                list.add(message);
            }
        }

        return list;
    }

    public List<Message> getSentMessages(User user){
        System.out.println("Fetching sent messages please wait..");
        Sleep.sleep(1000);

        if(!user.isLoggedIn()){
            System.out.println("User is not logged in. Please log in first..");
            return null;
        }

        List<Message> list = new ArrayList<>();

        for(Message message: messages){
            if(message.getUser() == user){
                list.add(message);
            }
        }

        return list;
    }


}
