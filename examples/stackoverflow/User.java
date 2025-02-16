package stackoverflow;

import java.util.*;

public class User {
    String userName;
    int reputation;
    List<Question> questions = new ArrayList<>();

    public User(String userName, int reputation) {
        this.userName = userName;
        this.reputation = reputation;
    }

    public void postQuestion(Question question){
        System.out.println("Successfully posted question...");
        questions.add(question);
    }
}
