package tictoegame;
import java.util.*;

import coffevendingmachine.Sleep;

public class Test {
    public static void main(String[] args) {
        TicToe ticToe = TicToe.getInstance();
        Random random = new Random();

        User user1 = ticToe.registerUser1("Rajesh");
        User user2 = ticToe.registerUser2("Mukesh");
        
        ticToe.startGame();
        User activeUser = user1;
        List<Integer> cells = new ArrayList<>();
        cells.addAll(Arrays.asList(0, 1, 2, 3 ,4 ,5, 6, 7, 8));
        
        while(!ticToe.checkWinner()){
            int idx = random.nextInt(cells.size());
            int n = cells.get(idx);
            cells.remove(idx);

            int x = n / 3, y = n % 3;
            System.out.println(activeUser.userName + " is thinking for making move..");
            Sleep.sleep(500);
            ticToe.move(activeUser, x, y);
            activeUser = (activeUser == user1)? user2: user1;
        }

    }
}
