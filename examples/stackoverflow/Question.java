package stackoverflow;

import java.util.*;

public class Question implements Votable, Commentable {
    List<Answer> answers = new ArrayList<>();
    List<Comment> comments = new ArrayList<>();
    List<Tag> tags = new ArrayList<>();
    User postedBy ;
    int upVotes = 0;
    String question;

    public Question(String question, User postedBy){
        this.question = question;
        this.postedBy = postedBy;
    }

    public void postAnswer(Answer answer){
        answers.add(answer);
        System.out.println("Answer posted successfully...");
    }

    @Override
    public synchronized void addComment(Comment comment){
        comments.add(comment);
        System.out.println("Comment added successfully..");
    }

    public void addTag(Tag tag){
        tags.add(tag);
        System.out.println("Tag added successfully...");
    }

    public synchronized void giveVote(){
        upVotes++;
        postedBy.reputation += 5;
        System.out.println("Upvoted question...");
    }
}
