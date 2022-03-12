package Searching.BinarySearch.Questions;

public class FindPivotOfRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,9,10};
        System.out.println(pivot(arr));
    }

    static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else if (start < mid) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
