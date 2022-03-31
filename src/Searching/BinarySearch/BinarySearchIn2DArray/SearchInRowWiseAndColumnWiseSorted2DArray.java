package Searching.BinarySearch.BinarySearchIn2DArray;

import java.util.Arrays;

/*
row wise and column wise  sorted
 {
  {10, 20, 0, 40},
  {15, 25, 35, 45},
  {28, 29, 37, 49},
  {33, 34, 38, 50}
  }
 */
public class SearchInRowWiseAndColumnWiseSorted2DArray {

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 0, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(search(arr, 45)));

    }

    static int[] search(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[]{row, col};
            }
            //if matrix[row][col] < target  is true  then the element is not in that row because all the
            //  value behind in this column is less than matrix[row][col]
            if (matrix[row][col] < target) {
                row++;
            } else {
                //if matrix[row][col] < target  is false  then the element is not in that column so check in another columns which is
                //less than matrix[row][col]
                col--;
            }
        }
        return new int[]{-1, -1};
    }
}
