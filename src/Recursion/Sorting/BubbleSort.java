package Recursion.Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String arg[]) {
        int[] arr = {0, 2, 11, 5, 39, 7, 0, 4, 5, 2, 3, 8, 0};
        System.out.println(Arrays.toString(bubbleSort(arr, 0, 0)));
        System.out.println(Arrays.toString(arr));

    }

    static int[] bubbleSort(int arr[], int i, int count) {
        if (count == -1) {
            return arr;
        }
        if (i  < arr.length -1) {
            if (arr[i] > arr[i + 1]) {
                int returnArray[] = swap(arr, i, i + 1);
                return bubbleSort(returnArray, i + 1, count + 1);
            } else {
                return bubbleSort(arr, i + 1, count);
            }
        } else {
            if (count > 0)
                return bubbleSort(arr, 0, 0);
            else
                return bubbleSort(arr, 0, -1);
        }
    }

    static int[] swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return arr;
    }


    //Method 2.

    static void bubbleSort1(int arr[], int r, int c) {
        if (r == 0) {
            return;
        }
        // for current Row
        if (c < r) {
            if (arr[c] > arr[c + 1]) {
                //swap
                int temp = arr[c];
                arr[c] = arr[c + 1];
                arr[c + 1] = temp;
            }
            bubbleSort(arr, r, c + 1);
        }
        // for Row change
        else {
            bubbleSort(arr, r - 1, 0);
        }
    }
}

