package tictoegame;

public class TicToe {
    private static TicToe ticToe = new TicToe();
    private Board board ;
    private User user1, user2;
    public static TicToe getInstance(){
        return ticToe;
    }

    public User registerUser1(String user1){
        this.user1 = new User(1, user1, "O");
        System.out.println("User registered successfully..");
        return this.user1;
    }

    public User registerUser2(String user2){
        this.user2 = new User(2, user2, "X");
        System.out.println("User registered successfully..");
        return this.user2;
    }

    public static void printGrid(Cell[][] grid) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                String symbol = (grid[i][j].user != null)? grid[i][j].user.symbol: "-" ;
                System.out.print(symbol + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public Board startGame(){
        board = new Board();
        board.reset();
        System.out.println("Game started.. Good luck");
        printGrid(board.grid);
        return board;
    }

    public boolean move(User user, int x, int y){
        boolean validMove = board.validateMove(user, x, y);
        if(!validMove){
            System.out.println("Invalid move..");
            printGrid(board.grid);
            return false;
        }
        board.move(user, x, y); 
        printGrid(board.grid);
        return true;
    }

    public boolean checkWinner(){
        User winner = board.checkWinner();
        if(winner != null){
            System.out.println(winner.userName + " Own the game..");
            return true;
        }
        if(board.checkDraw()){
            System.out.println("Match draw..");
            return true;
        }
        return false ;
    }
}
