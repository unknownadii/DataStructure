package Searching.BinarySearch.Questions;

public class FloorOFANumber {
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,9,12,45,67,89};
        int target = 15;
        int ans = floorOfNumber(arr, target);
        System.out.println(ans);
    }

    // return the index
    // return -1 if it does not exist
    static int floorOfNumber(int[] arr, int target) {

        if (target < arr[0]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
            // int mid = (start + end) / 2;
            // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        //If answer is not found than
        // the end index is at value which is less than target value
        return end;
    }
}
