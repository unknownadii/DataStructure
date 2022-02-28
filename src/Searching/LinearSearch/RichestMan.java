package Searching.LinearSearch;

public class RichestMan {
    public static void main(String[] args) {
        int arr[][] = {
                {2, 8, 7},
                {7, 1, 3},
                {1, 9, 5}
        };
        System.out.println(findRichest(arr));
    }

    static int findRichest(int[][] accounts) {
        int ansMax = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            if (sum > ansMax) {
                ansMax = sum;
            }
        }
        return ansMax;
    }
}
