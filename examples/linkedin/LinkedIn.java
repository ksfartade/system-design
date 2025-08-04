package linkedin;

import java.util.ArrayList;
import java.util.List;

public class LinkedIn {
    private static LinkedIn linkedIn = new LinkedIn();

    public static LinkedIn getInstance(){
        return linkedIn;
    }
    
    AuthService authService = AuthService.getInstance();

    public List<User> searchUsers(String name){
        System.out.println("Seaching for relevant users.. please wait...");
        Sleep.sleep(1000);
        
        List<User> list = new ArrayList<>();
        for(User user : authService.users.values()){
            if(user.getUserName().contains(name)){
                list.add(user);
            }
        }

        return list;
    }

}
