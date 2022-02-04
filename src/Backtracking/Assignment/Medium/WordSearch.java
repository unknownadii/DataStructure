package Backtracking.Assignment.Medium;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */
public class WordSearch {

    public static void main(String[] args) {
        boolean arr[][] = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        char ch[][] = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

    }

    static boolean search(char ch[][], boolean arr[][], String word, int row, int col) {
        if (row == ch.length - 1 && col == ch[0].length) {
            return false;
        }
        if (!arr[row][col]) {
            return false;
        }
        arr[row][col] = false;
        char c = word.charAt(0);
        boolean retVal = false;
        if (row < ch.length - 1) {
            if (c == ch[row][col]) {
                arr[row][col] = true;//checking row index so that it can't cross the matrix
                retVal = search(ch, arr, word.substring(1), row + 1, col);//down step
            }
        }
        if (col < ch[0].length - 1) {//checking column index so that it can't cross the matrix
            if (c == ch[row][col]) {
                arr[row][col] = true;
                retVal = search(ch, arr, word.substring(1), row, col + 1);//right step
            }
        }
        if (row > 0) {
            if (c == ch[row][col]) {
                arr[row][col] = true;
                retVal = search(ch, arr, word.substring(1), row - 1, col);//up step
            }
        }
        if (col > 0) {
            if (c == ch[row][col]) {
                arr[row][col] = true;
                retVal = search(ch, arr, word.substring(1), row, col - 1);//left step
            }
        }
        return retVal;
    }
}
