package Recursion.Array;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 8, 9, 11, 9, 234, 23};
        System.out.println(linearSearch(arr, 9, 0));
        System.out.println("First Index:" + linearSearchFirstIndex(arr, 9, 0));
        System.out.println("Last Index:" + linearSearchLastIndex(arr, 9, arr.length - 1));

        // Returning Arraylist
        // Method 1
        linearSearchAllIndex(arr, 9, 0);
        System.out.println(list);
        //Method 2
        System.out.println(linearSearchAllIndexReturnBtArrayList(arr, 9, 0, new ArrayList<>()));
        // Method 2 OR
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(linearSearchAllIndexReturnBtArrayList(arr, 9, 0, list));
        // Method 3 With out Passing ArrayList while function call
        System.out.println(linearSearchAllIndexReturnBtArrayList2(arr, 9, 0));
        System.out.println(linearSearchAllIndexReturnBtArrayList2Method2(arr, 9, 0));

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

    //type 1
    static ArrayList linearSearchAllIndexReturnBtArrayList(int[] arr, int target, int n, ArrayList<Integer> list) {
        if (n == arr.length) {
            return list;
        }
        if (target == arr[n]) {
            list.add(n);
        }
        return linearSearchAllIndexReturnBtArrayList(arr, target, n + 1, list);
    }

    //type 2
    static ArrayList linearSearchAllIndexReturnBtArrayList2(int[] arr, int target, int n) {
        ArrayList<Integer> list;
        if (n == arr.length) {
            return new ArrayList<>();
        }
        if (target == arr[n]) {
            list = linearSearchAllIndexReturnBtArrayList2(arr, target, n + 1);
            list.add(n);
            return list;
        }
        return linearSearchAllIndexReturnBtArrayList2(arr, target, n + 1);
    }

    // type 2 method 2
    static ArrayList linearSearchAllIndexReturnBtArrayList2Method2(int[] arr, int target, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n == arr.length) {
            return list;
        }
        if (target == arr[n]) {
            list.add(n);
        }
        ArrayList<Integer> incomingListFromBelow = linearSearchAllIndexReturnBtArrayList2Method2(arr, target, n + 1);
        list.addAll(incomingListFromBelow);
        return list;
    }

}
