package Backtracking;

import java.util.ArrayList;

/*
Source = (3,3)
Destination = (1.1)
 */
public class MazeOnlyRightAndDownSteps {
    public static void main(String[] args) {
        mazePrintPath2(3, 3, "");
        System.out.println(mazeCountPath(3, 3));
        mazePrintPath(3, 3, "");
        System.out.println(mazePathReturnInArraylist(3, 3, ""));
    }

    static int mazeCountPath(int row, int col) {
        if (row == 1 && col == 1) { // when it will reach to index(1,1)
            return 1;
        }
        if (row < 1) { //checking row index so that it can't cross the matrix
            return 0;
        }
        if (col < 1) { //checking column index so that it can't cross the matrix
            return 0;
        }
        int left = mazeCountPath(row - 1, col);
        int right = mazeCountPath(row, col - 1);
        return left + right;
    }

    static void mazePrintPath(int row, int col, String processed) {
        if (row == 1 && col == 1) { // when it will reach to index(1,1)
            System.out.println(processed);
            return;
        }
        if (row < 1) { //checking row index so that it can't cross the matrix
            return;
        }
        if (col < 1) { //checking column index so that it can't cross the matrix
            return;
        }
        mazePrintPath(row - 1, col, processed + 'd');//down step
        mazePrintPath(row, col - 1, processed + "r");//right step

    }


    static void mazePrintPath2(int row, int col, String processed) {
        if (row == 1 && col == 1) { // when it will reach to index(1,1)
            System.out.println(processed);
            return;
        }
        if (row > 1) { //checking row index so that it can't cross the matrix
            mazePrintPath2(row - 1, col, processed + 'd');//down step
        }
        if (col > 1) { //checking column index so that it can't cross the matrix
            mazePrintPath2(row, col - 1, processed + "r");//right step
        }
    }

    static ArrayList<String> mazePathReturnInArraylist(int row, int col, String processed) {
        if (row == 1 && col == 1) { // when it will reach to index(1,1)
            ArrayList<String> s = new ArrayList<>();
            s.add(processed);
            return s;
        }
        ArrayList<String> st = new ArrayList<>();
        if (row > 1) { //checking row index so that it can't cross the matrix
            ArrayList<String> d = mazePathReturnInArraylist(row - 1, col, processed + 'd');//down step
            st.addAll(d);
        }
        if (col > 1) { //checking column index so that it can't cross the matrix
            ArrayList<String> r = mazePathReturnInArraylist(row, col - 1, processed + "r");//right step
            st.addAll(r);
        }
        return st;
    }
}
