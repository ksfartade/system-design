package tictoegame;

public class Board {
    Cell[][] grid ;

    public Board(){
        grid = new Cell[3][3];
    }

    public Cell[][] reset(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                grid[row][col] = new Cell(row, col);
            }
        }
        System.out.println("Grid reset successfully..");
        return grid;
    }

    public boolean validateMove(User user, int x, int y){
        return grid[x][y].user == null;
    }

    public void move(User user, int x, int y){
        grid[x][y].user = user;
        System.out.println("Move successfull");
    }

    public User checkWinner(){
        boolean check = false;
        for(int i = 0; i < 3; i++){
            check = (grid[i][0].user != null && grid[i][0].user == grid[i][1].user && grid[i][1].user == grid[i][2].user);
            if(check){
                return grid[i][0].user;
            }
            check = (grid[0][i].user != null && grid[0][i].user == grid[1][i].user && grid[1][i].user == grid[2][i].user);
            if(check){
                return grid[0][i].user;
            }
        }

        check = (grid[0][0].user != null && grid[0][0].user == grid[1][1].user && grid[1][1].user == grid[2][2].user );
        if(check){
            return grid[0][0].user;
        }
        check = (grid[0][2].user != null && grid[0][2].user == grid[1][1].user && grid[1][1].user == grid[2][0].user );
        if(check){
            return grid[0][2].user;
        }
        return null;
    }

    public boolean checkDraw(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(grid[row][col].user == null){
                    return false;
                }
            }
        }
        return true;
    }
}
