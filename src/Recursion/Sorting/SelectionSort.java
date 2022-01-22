package Recursion.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,3,2 ,0,0,0,0,0,0,0,0,1,6};
        selectionSort(arr,arr.length,0,0);
        System.out.println(Arrays.toString(arr));
    }
    static void selectionSort(int[] arr,int r ,int c,int max)
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
            else
            {
                // put this recursion in else or it will run every time after leaving the if condition brackets
                selectionSort(arr,r,c+1,max);
            }
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
