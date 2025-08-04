package taskmanager;

import java.time.LocalDateTime;
import java.util.*;

public class TaskManager {
    int taskCount = 0, userCount = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private List<User> users = new ArrayList<>();

    private static TaskManager taskManager = new TaskManager();

    public static synchronized TaskManager getInstance(){
        return taskManager;
    }

    public synchronized User addUser(String userName, String position){
        User user = new User(++userCount, userName, position);
        users.add(user);
        System.out.println("New user created successfully..");
        return user;
    }

    public synchronized Task addTask(User user, String description, LocalDateTime dueDate, Status status, int priority){
        Task task = new Task(user, description, dueDate, status, priority, ++taskCount);
        tasks.put(taskCount, task);
        System.out.println("Task created successfully..");
        return task;
    }


    public Task update(int taskId, User user, String description, LocalDateTime dueDate, Status status, int priority){
        Task task = tasks.getOrDefault(taskId, null) ;

        if(task == null){
            System.out.println("Requested task could not found..");
            return null;
        }
        
        synchronized (task){
            task.update(user, description, dueDate, status, priority);
        }
        
        System.out.println("Task udpated successfully..");
        return task;
    }

    public void delete(int taskId){
        Task task = tasks.getOrDefault(taskId, null);
        task.id = 0;
        task.user = null;
        System.out.println("Task deleted successfully");
    }

    public Task assignTask(int taskId, User user){
        Task task = tasks.getOrDefault(taskId, null);
        task.user = user;
        System.out.println("Task: " + task.id + " assigned to: " + user.userName + " successfully..");
        return task;
    }

    public Task setRemainder(LocalDateTime dueDate, int taskId){
        Task task = tasks.getOrDefault(taskId, null);
        task.dueDate = dueDate;
        System.out.println("Remainder of the task: " + task.id + " updated successfully..");
        return task;
    }

    public List<Task> search(int priority, LocalDateTime dueDate, User user){
        List<Task> result = new ArrayList<>();
        for(Task task: tasks.values()){
            if(task.priority == priority){
                result.add(task);
            }
            else if(task.dueDate.equals(dueDate)){
                result.add(task);
            }
            else if(task.user!=null && task.user.equals(user)){
                result.add(task);
            }
        }

        return result;
    }

    public Task markAsCompleted(int taskId){
        Task task = tasks.getOrDefault(taskId, null);
        task.status = Status.COMPLETED;
        System.out.println("Task marked as completed successfully..");
        return task;
    }

    

}
