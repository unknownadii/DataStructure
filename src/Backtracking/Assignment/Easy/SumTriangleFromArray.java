package Backtracking.Assignment.Easy;

import java.util.ArrayList;
import java.util.Arrays;

/*
https://www.geeksforgeeks.org/sum-triangle-from-array/

Given an array of integers, print a sum triangle from it such that the first level has all array elements. From then, at each level number of elements is one less than the previous level and elements at the level is be the Sum of consecutive two elements in the previous level.
Example :

Input : A = {1, 2, 3, 4, 5}
Output : [48]
         [20, 28]
         [8, 12, 16]
         [3, 5, 7, 9]
         [1, 2, 3, 4, 5]

Explanation :
Here,   [48]
        [20, 28] -->(20 + 28 = 48)
        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
 */
public class SumTriangleFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        printTriangle(arr);
    }

    static void printTriangle(int[] arr) {

        if (arr.length < 1){
            return;
        }
        int[] a = new int[arr.length-1];
        for (int i=0;i< arr.length-1 ;i++){
            a[i]= arr[i] + arr[i+1];
        }
        printTriangle(a);
        System.out.println(Arrays.toString(arr));
    }
}

