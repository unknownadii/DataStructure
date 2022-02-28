package Searching.LinearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int arr[][] = {
                {43, 52, 6, 2, 5, 3, 23},
                {434, 52, 36, 2, 5, 3, 23},
                {453, 52, 6, 2, 5, 33, 23},
                {453, 565, 6, 2, 5, 33, 23},
                {43, 52, 6, 2, 535, 3, 2543}
        };
        System.out.println(Arrays.toString(searchIn2d(arr, 2543)));
    }

    static int[] searchIn2d(int[][] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == n) {
                    return new int[]{i, j};//it will return the index
                }
            }
        }
        return new int[]{-1, -1};
    }
}
