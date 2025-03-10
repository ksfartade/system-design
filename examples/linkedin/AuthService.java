package linkedin;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AuthService {
    ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();

    private static AuthService authService = new AuthService();
    public static AuthService getInstance(){
        return authService;
    }

    public synchronized User register(String userName, String password){
        if(users.contains(userName)){
            System.out.println("User already registered. Please login or forgot password..");
            return users.get(userName);
        }

        System.out.println("Registering user please wait...");
        Sleep.sleep(1000);

        User user = new User(userName, hashPassword(password));
        System.out.println("User registed successfully. Please log in.");
        users.put(userName, user);
        return user;
    }

    public String login(String userName, String password){
        System.out.println("Logging please wait...");
        Sleep.sleep(1000);
        synchronized(userName){
            User user = users.getOrDefault(userName, null);
            if(user != null){
                if(user.getPassword().equals(hashPassword(password))){
                    user.setLoggedIn(true);
                    System.out.println("User logged in successfully..");
                    String token = UUID.randomUUID().toString();
                    user.setToken(token);
                    return user.getToken();
                }
                System.out.println("Wrong password..");
                return null;
            }

            System.out.println("User not found...");
            return null;
        }
    }

    public boolean logout(String userName){
        System.out.println("Logging out. please wait..");
        Sleep.sleep(1000);
        synchronized(userName){
            User user = users.get(userName);
            if(user != null){
                user.setLoggedIn(false);
                user.setToken(null);
                System.out.println("logged out successfully");
                return true;
            }
            System.out.println("User not found..");
            return false;
        }
    }

    public String hashPassword(String password){
        return String.valueOf(password.hashCode());
    }
}
