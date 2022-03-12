package Searching.BinarySearch.Questions;

public class SearchInRotatedSortedArray {
    public static void main(String[] arg) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedArray(arr, 7));
    }

    static int searchInRotatedArray(int arr[], int target) {
        int pivot = pivot(arr);

        // if you did not find a pivot, it means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        // if pivot is found, you have found 2 asc sorted arrays
        if (arr[pivot] == target) {
            return pivot;
        }

        if (target >= arr[0]) {
            return binarySearch(arr, target, 0, pivot - 1);
        }

        return binarySearch(arr, target, pivot + 1, arr.length - 1);
    }

    static int binarySearch(int[] arr,int target, int start, int end) {
        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
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
        return -1;
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

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
