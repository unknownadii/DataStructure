package Recursion.Array;

import java.util.ArrayList;
import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 8, 9, 11, 9, 234, 23};
        System.out.println(linearSearch(arr, 9, 0));
        System.out.println("First Index:" + linearSearchFirstIndex(arr, 9, 0));
        System.out.println("Last Index:" + linearSearchLastIndex(arr, 9, arr.length - 1));
        linearSearchAllIndex(arr, 9, 0);
        System.out.println(list);
    }

    static Boolean linearSearch(int[] arr, int target, int n) {
        if (n > arr.length - 1) {
            return false;
        }
        if (target == arr[n]) {
            return true;
        } else
            return linearSearch(arr, target, n + 1);
    }

    static int linearSearchFirstIndex(int[] arr, int target, int n) {
        if (n == arr.length) {
            return -1;
        }
        if (target == arr[n]) {
            return n;
        } else
            return linearSearchFirstIndex(arr, target, n + 1);
    }

    static int linearSearchLastIndex(int[] arr, int target, int n) {
        if (n == 0) {
            return -1;
        }
        if (target == arr[n]) {
            return n;
        } else
            return linearSearchLastIndex(arr, target, n - 1);
    }

    //Return all index of number in array
    static ArrayList<Integer> list = new ArrayList<>();

    static void linearSearchAllIndex(int[] arr, int target, int n) {
        if (n == arr.length) {
            return;
        }
        if (target == arr[n]) {
            list.add(n);
        }
        linearSearchAllIndex(arr, target, n + 1);
    }
}
