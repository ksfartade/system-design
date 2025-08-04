package linkedin;

import linkedin.profile.Profile;

public class User {
    private String userName, password, token;
    private Profile profile;
    private boolean loggedIn;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public void setLoggedIn(boolean login){
        this.loggedIn = login;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void notify(Notification notificaion){
        System.out.println("Received notification: " + notificaion.message);
    }
}
