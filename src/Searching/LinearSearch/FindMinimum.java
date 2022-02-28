package Searching.LinearSearch;

public class FindMinimum {
    public static void main(String[] args) {
        int[] arr = {10,25,41,6,24,6,313,44};
        System.out.println(minimum(arr));
    }

    static int minimum(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Empty Array");
            return 0;
        }
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min=arr[i];
            }
        }
        return min;
    }
}
