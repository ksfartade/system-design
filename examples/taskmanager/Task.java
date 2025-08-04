package taskmanager;

import java.time.LocalDateTime;


public class Task {
    public User user;
    String description;
    LocalDateTime dueDate ;
    Status status;
    int priority;
    int id;

    public Task(User user, String description, LocalDateTime dueDate, Status status, int priority, int id) {
        this.description = description;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.id = id;
        this.user = user;
    }

    public void assign(User user){
        this.user = user;
        System.out.println("Task: " + this.id + " assigned successfully to the user: " + user.id);
    }

    public void update(User user, String description, LocalDateTime dueDate, Status status, int priority) {
        this.user = user;
        this.dueDate = dueDate;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Task id: " + id + " duDate: " + dueDate + " " + description.substring(0, Math.min(50, description.length()));
    }

    
}
