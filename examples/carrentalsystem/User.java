package carrentalsystem;

public class User {
    String name, license, contact;
    int id;
    public User(String name, int id, String license, String contact) {
        this.name = name;
        this.id = id;
        this.license = license;
        this.contact = contact;
    }    
}
