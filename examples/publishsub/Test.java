package publishsub;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        PubSub pubSub = PubSub.getInstance();

        User rajesh = pubSub.addUser("Rajesh");
        User mukesh = pubSub.addUser("Mukesh");

        Topic django = pubSub.createTopic("Django", rajesh);
        Topic aws = pubSub.createTopic("AWS", rajesh);
        Topic Nginx = pubSub.createTopic("Nginx", rajesh);
        pubSub.subscribe(mukesh, django);

        Message rajeshM1 = pubSub.addMessage(rajesh, "Let learn how to deloy django applications on AWS", Arrays.asList("Django", "AWS", "Nginx"));

    }
}
