package Searching.LinearSearch;

public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {1,2,41,6,24,6,313,44};
        System.out.println(search(arr,1,6,6));
    }

    static int search(int[] arr, int from,int to,int n) {
        if (arr.length == 0) {
            return -1;
        }

        // find the in the array
        for (int i = from; i <= to && i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
