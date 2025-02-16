package stackoverflow;

import java.util.*;

public class StackOverflow {
    List<User> users = new ArrayList<>();

    private static StackOverflow stackOverflow;

    public static StackOverflow getInstance(){
        if(stackOverflow == null){
            stackOverflow = new StackOverflow();
        }
        return stackOverflow;
    }

    public void addUser(User user){
        users.add(user);
    }

    public Question postQuestion(String question_text, User user){
        Question question = new Question(question_text, user);
        System.out.println("Posting question...");
        Sleep.sleep(2);
        user.postQuestion(question);
        return question;
    }

    public Answer postAnswer(String answer_text, Question question, User postedBy){
        Answer answer = new Answer(answer_text, postedBy);
        System.out.println("Posting answer...");
        Sleep.sleep(2);
        question.postAnswer(answer);
        return answer;
    }

    public void questionComment(Question question, String comment_text, User postedBy){
        Comment comment = new Comment(comment_text, postedBy);
        System.out.println("Posting comment for question...");
        Sleep.sleep(1);
        question.addComment(comment);
    }

    public void answerComment(Answer answer, String comment_text, User postedBy){
        Comment comment = new Comment(comment_text, postedBy);
        System.out.println("Posting comment for answer...");
        Sleep.sleep(1);
        answer.addComment(comment);
    }

    public synchronized void addTag(Tag tag, Question question){
        System.out.println("Adding tag to the question...");
        Sleep.sleep(1);
        question.addTag(tag);
    }

    public List<Question> search(String word){
        System.out.println("Wait we are searching..");
        Sleep.sleep(2);
        List<Question> questions = new ArrayList<>();
        for(User user: users){
            if(user.userName.contains(word)){
                questions.addAll(user.questions);
            }
            else{
                for(Question question: user.questions){
                    if(question.question.contains(word)){
                        questions.add(question);
                    }
                    else{
                        for(Tag tag: question.tags){
                            if(tag.getName().contains(word)){
                                questions.add(question);
                            }
                        }
                    }
                }
            }
        }

        return questions;
    }

    public void giveVote(Votable vote){
        System.out.println("Adding vote..");
        Sleep.sleep(1);
        vote.giveVote();
    }
}
