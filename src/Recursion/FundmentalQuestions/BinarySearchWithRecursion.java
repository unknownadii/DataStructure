// find the middle element then check with target value if it matches then return mid value
// if not in mid then check in left and right.

package Recursion.FundmentalQuestions;
public class BinarySearchWithRecursion {
    public static void main(String[] args) {
        int[] arr = {1,5,9,44,56,78,211};
        System.out.println(binarySearch(arr,44,0,arr.length));

    }
    static int binarySearch(int[] arr , int target , int start ,int end)
    {
        if(start > end)
        {
            return -1;
        }
        int mid =  (start + end) /2;
        if (arr[mid]== target)
        {
            return mid;
        }
        if (arr[mid] > target)
        {
            return binarySearch(arr,target,start,mid-1);

        }
        return binarySearch(arr,target,mid+1 ,end);
    }
}
