package Searching.BinarySearch.Questions;

public class SearchInRotatedSortedArray {
    public static void main(String[] arg) {
        int[] arr = {4, 5, 6, 7, 8, 3, 2};
        System.out.println(searchInRotatedArray(arr, 0));
    }

    static int searchInRotatedArray(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < 0 && arr[mid - 1] == target) {
                return mid - 1;
            }
        }
        return -1;
    }

}
