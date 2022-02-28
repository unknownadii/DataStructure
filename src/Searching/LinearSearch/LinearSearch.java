package Searching.LinearSearch;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,41,6,24,6,313,44};
        System.out.println(search(arr,42));
    }

    //search in the array and find a number if find's it then return the index else -1
    static int search(int[] arr, int n) {
        if (arr.length == 0) {
            return -1;
        }

        // find the in the array
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
