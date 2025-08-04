package hotelmanagement;

public class User {
    public UserType userType;
    public int id;
    public String userName;
    public User(UserType userType, int id, String userName) {
        this.userType = userType;
        this.id = id;
        this.userName = userName;
    }
}
