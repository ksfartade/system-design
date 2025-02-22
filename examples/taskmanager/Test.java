package taskmanager;

import java.time.LocalDateTime;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        User rajesh = taskManager.addUser("Rajesh", "Full stack developer");
        User mukesh = taskManager.addUser("Mukesh", "Dev Ops");

        taskManager.addTask(rajesh, "Template id different for each business", LocalDateTime.of(2025, 2, 25, 0, 0, 0),  Status.NEW, 5);
        taskManager.addTask(mukesh, "Server memory full issue", LocalDateTime.of(2025, 2, 23, 0, 0, 0),  Status.NEW, 8);

        List<Task> tasks = taskManager.search(-1, LocalDateTime.of(2025, 2, 25, 0, 0), mukesh);
        System.out.println("Your search result: " + tasks);
    }
}
