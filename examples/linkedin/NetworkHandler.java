package linkedin;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import linkedin.network.Connection;
import linkedin.network.ConnectionStatus;

public class NetworkHandler {
    private static NetworkHandler networkHandler = new NetworkHandler();
    List<Connection> connections = new ArrayList<>();

    public static NetworkHandler getInstance(){
        return networkHandler;
    }


    public Connection sendConnection(User from, User to){
        if(!from.isLoggedIn()){
            System.out.println("User is not logged in...");
            return null;
        }

        Connection connection = new Connection(from, to, LocalDateTime.now());
        connections.add(connection);
        Notification notification = new Notification("New connection request", NotificationType.NEWCONNECTION);
        to.notify(notification);
        System.out.println("Connection request sent successfully...");
        return connection;
    }

    public boolean acceptConnection(User user, Connection connection){
        System.out.println("Accepting connection please wait...");
        Sleep.sleep(1000);

        if(!user.isLoggedIn()){
            System.out.println("User is not logged in.. Please log in..");
            return false;
        }
        
        if(connection.getReceiver() != user){
            System.out.println("You can't decline the connection...");
            return false;
        }

        connection.accept();
        System.out.println("You are now connected...");
        return true;
    }

    public boolean declineConnection(User user, Connection connection){
        System.out.println("Decling connection please wait...");
        Sleep.sleep(1000);

        if(!user.isLoggedIn()){
            System.out.println("User is not logged in.. Please log in..");
            return false;
        }
        
        if(connection.getReceiver() != user){
            System.out.println("You can't decline the connection...");
            return false;
        }

        connection.decline();
        System.out.println("Connection removed...");
        return true;
    }

    public List<Connection> getSentConnections(User user){
        System.out.println("Fetching sent connections, please wait..");
        Sleep.sleep(1000);
        if(!user.isLoggedIn()){
            System.out.println("User is not logged in.. Please login..");
            return null;
        }

        List<Connection> list = new ArrayList<>();
        for(Connection connection : connections){
            if(connection.getSender() == user && connection.getStatus() == ConnectionStatus.NEW){
                list.add(connection);
            }
        }
        return list;
    }


    public List<Connection> getConnections(User user){
        System.out.println("Fetching your connections, please wait..");
        Sleep.sleep(1000);
        if(!user.isLoggedIn()){
            System.out.println("User is not logged in.. Please login..");
            return null;
        }

        List<Connection> list = new ArrayList<>();
        for(Connection connection : connections){
            if((connection.getSender() == user || connection.getReceiver() == user ) && connection.getStatus() == ConnectionStatus.ACCEPTED){
                list.add(connection);
            }
        }
        return list;
    }

    public boolean checkConnection(User user, User to){
        for(Connection connection: getConnections(user)){
            if(connection.getSender() == to || connection.getReceiver() == to){
                return true;
            }
        }

        return false;
    }

}
