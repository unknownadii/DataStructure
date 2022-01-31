package Backtracking.Assignment.Easy;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SumTriangleFromArray2 {
    public static void main(String[] args) {
        long[] arr = {1, 2, 3, 4, 5};
        getTriangle(arr, arr.length);
    }
    //here we returing long just only distrack purpose
    static long[] getTriangle(long arr[], long n) {

        if (n < 1) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
                System.out.println();
            }
            return new long[0];
        }

        long temp[] = new long[arr.length - 1];
        for (int i = 0; i < n - 1; i++) {
            temp[i] = arr[i] + arr[i + 1];

        }

        getTriangle(temp, n - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
        return new long[0];
    }
}


