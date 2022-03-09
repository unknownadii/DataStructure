// find the ceiling of the given in array
// Ex= a[] = {1,2,3,5,6,7,8} target= 4
// answer is find the smallest element in array which is greater or equal to the target number

package Searching.BinarySearch.Questions;

public class CeilingOfANumber {
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,9,12,45,67,89};
        int target = 15;
        int ans = ceilOfNumber(arr, target);
        System.out.println(ans);
    }

    // return the index
    // return -1 if it does not exist
    static int ceilOfNumber(int[] arr, int target) {

        if (target > arr[arr.length-1]){
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
        // the start index is at value which is greater than target value
        return start;
    }
}
