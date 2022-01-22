package Recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 2, 11, 5, 39, 7, 0, 4, 5, 2, 3, 8, 0};
        selectionSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int arr[],int r ,int c,int max)
    {
        if (r==0)
        {
            return;
        }
        // for current Row
        if (c < r )
        {
            if (arr[c] > arr[max])
            {
                selectionSort(arr,r,c+1,c);
            }
            selectionSort(arr,r,c+1,max);
        }
        // for Row change
        else {
            //swap
            // r-1 will be the last index of the row after every traversal
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selectionSort(arr,r-1,0,0);
        }
    }
}
