package Backtracking.BacktrakingQuestions;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMazeAllDirectionAllowedWithMatrixOfPath {
    public static void main(String[] args) {
        Boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[board.length][board[0].length];
        mazePrintPath(board, 0, 0, "", path, 1);

    }


    static void mazePrintPath(Boolean[][] maze, int row, int col, String processed, int[][] path, int steps) {
        if (row == maze.length - 1 && col == maze[0].length - 1) { // when it will reach to index(1,1)
            for (int[] arr : path) {
                path[row][col] = steps;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }
        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;//marking this block as false so that we can't come
        // at this position to avoid infinite loop
        path[row][col] = steps;

        if (row < maze.length - 1) { //checking row index so that it can't cross the matrix
            mazePrintPath(maze, row + 1, col, processed + 'd', path, steps + 1);//down step
        }
        if (col < maze[0].length - 1) { //checking column index so that it can't cross the matrix
            mazePrintPath(maze, row, col + 1, processed + "r", path, steps + 1);//right step
        }
        if (row > 0) {
            mazePrintPath(maze, row - 1, col, processed + "u", path, steps + 1);//up step
        }
        if (col > 0) {
            mazePrintPath(maze, row, col - 1, processed + "l", path, steps + 1);//left step
        }
        maze[row][col] = true;
        //marking this block as true because as Backtracking
        // says revert back every chances as it was before recursion call
        path[row][col] = 0;
        //we correcting it to the same position because path will br same in all the recursion phase
        // so modify it
    }

}
