package Backtracking.BacktrakingQuestions;

/*
count the no ways to place a queens in a board
 */
public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean board[][] = new boolean[n][n];
                System.out.println(countWays(board,0));
    }

    static int countWays(boolean board[][], int row) {
        if (row == board.length) {
            printWays(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < board[0].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += countWays(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static void printWays(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else
                    System.out.print("X ");
            }
            System.out.println();
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //checking vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        //checking left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        //checking Right diagonal
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col +i]) {
                return false;
            }
        }
        return true;
    }
}
