package linkedin;

import java.util.ArrayList;
import java.util.List;

import linkedin.message.Message;
import linkedin.network.Connection;


public class Test{
    public static void main(String[] args) {
        
        AuthService authService = AuthService.getInstance();
        NetworkHandler networkHandler = NetworkHandler.getInstance();
        MessageHandler messageHandler = MessageHandler.getInstance();
        ProfileHandler profileHandler = ProfileHandler.getInstance();


        User rajesh = authService.register("Rajesh", "123");

        String token = authService.login("Rajesh", "123");

        User mukesh = authService.register("Mukesh", "123");
        User gukesh = authService.register("Gukesh", "123");
        String token1 = authService.login("Gukesh", "123");
        Connection connection1 = networkHandler.sendConnection(gukesh, mukesh);


        Connection connection = networkHandler.sendConnection(rajesh, mukesh);

        networkHandler.acceptConnection(mukesh, connection);
        networkHandler.acceptConnection(mukesh, connection1);

        Message message = messageHandler.sendMessage(rajesh, mukesh, "Hey hi bro...");

        List<Message> sentMessages = messageHandler.getSentMessages(rajesh);
        System.out.println("ALl sent messages of rajesh: "+ sentMessages);
        List<Message> getAllmessages = messageHandler.getAllMessages(rajesh, mukesh);
        System.out.println("All messages of mukesh: " + getAllmessages);

    }
}