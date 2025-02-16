package stackoverflow;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        User user1 = new User("Munna Bhai", 5);
        User user2 = new User("Raju Bhai", 3);

        stackOverflow.addUser(user1);
        stackOverflow.addUser(user2);
        
        Question question = stackOverflow.postQuestion("What are the types of time complexities calculations...", user1);

        Answer answer = stackOverflow.postAnswer("There are 3 ways to calculate time complexites.", question, user2);

        stackOverflow.giveVote(question);

        List<Question> questions = stackOverflow.search("time complexities");
        System.out.println("Here is the search result..");
        for(Question question2: questions){
            System.out.println(question2.question);
        }
        
        
        stackOverflow.addTag(Tag.DSA, question);
    }
}
