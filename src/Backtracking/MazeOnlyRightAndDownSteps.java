package Backtracking;

/*
Source = (3,3)
Destination = (1.1)
 */
public class MazeOnlyRightAndDownSteps {
    public static void main(String[] args) {
        System.out.println(mazeCountPath(4,4));
        mazePrintPath(4,4,"");
    }

    static int mazeCountPath(int row, int col) {
        if (row < 1) { //checking row index so that it can't cross the matrix
            return 0;
        }
        if (col < 1) { //checking column index so that it can't cross the matrix
            return 0;
        }
        if (row == 1 && col == 1) { // when it will reach to index(1,1)
            return 1;
        }
        int left = mazeCountPath(row - 1, col);
        int right = mazeCountPath(row, col - 1);
        return left + right;
    }

    static void mazePrintPath(int row, int col, String processed) {
        if (row < 1) { //checking row index so that it can't cross the matrix
            return;
        }
        if (col < 1) { //checking column index so that it can't cross the matrix
            return;
        }
        if (row == 1 && col == 1) { // when it will reach to index(1,1)
            System.out.println(processed);
            return;
        }
        mazePrintPath(row - 1, col,processed + 'd' );//down step
        mazePrintPath(row, col - 1,processed + "r" );//right step

    }
}
