package Recursion.Array;

public class CheckTheIsSorted {
    public static void main(String[] args) {
        int[] arr = {1,2,4,6,7,8,9,22,44,44};
        System.out.println(isSorted2(arr,0));
    }

    //Method 1
    static Boolean isSorted(int[] arr, int i)
    {
        if (i==arr.length-1)
        {
            return true;
        }
        if (arr[i]<=arr[i+1])
        {
            return isSorted(arr,i+1);
        }
      return false;
    }

    //Method 2
    static boolean isSorted2(int arr[],int n)
    {
        if (n==arr.length-1)
        {
            return true;
        }
        return arr[n] <= arr[n+1] && isSorted2(arr,n+1);
    }
}
