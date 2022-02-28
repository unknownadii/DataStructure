package Searching.LinearSearch;

public class FindMaxIn2DArray {
    public static void main(String[] args) {
        int arr[][] = {
                {43, 52, 6, 2, 5, 3, 23},
                {434, 52, 36, 2, 5, 3, 23},
                {453, 52, 6, 2, 5, 3333, 23},
                {453, 565, 6, 2, 5, 33, 23},
                {43, 52, 6, 2, 535, 3, 2543}
        };
        System.out.println(max(arr));
    }

    static int max(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] i : arr) {
            for (int j : i) {
                if (j > max) {
                    max = j;
                }
            }
        }
        return max;
    }
}
