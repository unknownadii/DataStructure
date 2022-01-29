package Backtracking.FoundationBacktrackingButUsingRecursionToSolve;

/*
Error = .StackOverflowError
this question will create Error while solving because if all direction were allowed then
 "RDLUR" , etc this type paths will create infinite loop
 So Use Backtracking method to solve wWith is in Backtacking/BacktrackingQuestions Package
 */
public class MazeWithAllStepsAllowed {
    public static void main(String[] args) {
        Boolean[][] board = {
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true}
        };
        mazePrintPath(board, 0, 0, "");

    }


    static void mazePrintPath(Boolean[][] maze, int row, int col, String processed) {
        if (row == maze.length - 1 && col == maze[0].length - 1) { // when it will reach to index(1,1)
            System.out.println(processed);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        if (row < maze.length - 1) { //checking row index so that it can't cross the matrix
            mazePrintPath(maze, row + 1, col, processed + 'd');//down step
        }
        if (col < maze[0].length - 1) { //checking column index so that it can't cross the matrix
            mazePrintPath(maze, row, col + 1, processed + "r");//right step
        }
        if (row > 0) {
            mazePrintPath(maze, row-1, col , processed + "u");//up step
        }
        if (col > 0) {
            mazePrintPath(maze, row, col - 1, processed + "l");//left step
        }
    }

}
