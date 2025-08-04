package stackoverflow;

import java.util.*;

public class Answer implements Votable, Commentable {
    int upVotes = 0;
    String ans ;
    User postedBy;
    List<Comment> comments = new ArrayList<>();

    public Answer(String ans, User postedBy){
        this.ans = ans;
        this.postedBy = postedBy;
    }

    @Override 
    public void addComment(Comment comment){
        System.out.println("Comment added successfully..");
        comments.add(comment);
    }

    public void giveVote(){
        upVotes++;
        postedBy.reputation += 4;
        System.out.println("Upvoted answer..");
    }
}
