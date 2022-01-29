package Backtracking;

import java.util.ArrayList;

/*
Source = (3,3)
Destination = (1.1)
 */
public class MazeWithObsticalsOnlyRightAndDownSteps {
    public static void main(String[] args) {
        Boolean[][] board = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        mazePrintPath2(board, 0, 0, "");
        System.out.println(mazeCountPath(board, 0, 0));
    }

    static int mazeCountPath(Boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) { // when it will reach to index(3,3)
            return 1;
        }
        if (!maze[row][col]) {
            return 0;
        }
        int left = 0, right = 0;
        if (row < maze.length - 1) { //checking row index so that it can't cross the matrix
            left = mazeCountPath(maze, row + 1, col);
        }
        if (col < maze[0].length - 1) { //checking column index so that it can't cross the matrix
            right = mazeCountPath(maze, row, col + 1);
        }
        return left + right;
    }


    static void mazePrintPath2(Boolean[][] maze, int row, int col, String processed) {
        if (row == maze.length - 1 && col == maze[0].length - 1) { // when it will reach to index(1,1)
            System.out.println(processed);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        if (row < maze.length - 1) { //checking row index so that it can't cross the matrix
            mazePrintPath2(maze, row + 1, col, processed + 'd');//down step
        }
        if (col < maze[0].length - 1) { //checking column index so that it can't cross the matrix
            mazePrintPath2(maze, row, col + 1, processed + "r");//right step
        }
    }

}
