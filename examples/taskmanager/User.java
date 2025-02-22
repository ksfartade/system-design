package taskmanager;

public class User {
    int id;
    String userName;
    String position;

    public User(int id, String userName, String position) {
        this.id = id;
        this.userName = userName;
        this.position = position;
    }

    @Override
    public boolean equals(Object user){
        if(user == null || getClass() != user.getClass()){
            return false;
        }
        
        return id == ((User)user).id;
    }
}
