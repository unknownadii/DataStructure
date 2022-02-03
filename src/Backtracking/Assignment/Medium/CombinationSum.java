package Backtracking.Assignment.Medium;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 */
public class CombinationSum {
    public static void main(String[] args) {
        int arr[]= {2,2,2,5};
        System.out.println(combinationSum(arr,7));
    }
    static List<List<Integer>> ml;
    public static List<List<Integer>> combinationSum ( int[] candidates, int target){
        //main list to store combinations.
        ml = new ArrayList<>();
        //Starting index is 0, then we will make two calls, one call will be when we pick that element,
        //other will be when we don't pick the element.
        findCombinations(candidates, 0, target, new ArrayList<>());
        return ml;
    }
    public static void findCombinations(int[] arr, int idx, int target, List<Integer> cl) {
        //If target becomes 0, then we will add the combination in the main list and return.
        //If index becomes equal to the length of the array, and target is not equal to 0, then simply return.
        if (target == 0 || idx == arr.length) {
            if (target == 0) {
                ml.add(new ArrayList<>(cl));
            }
            return;
        }

        //First Call : We pick the element. But we can only pick the element if it is less than the target.
        if (arr[idx] <= target) {
            //Add the element in the child list.
            cl.add(arr[idx]);
            //After adding the element in child list we pick the element, so we have to decrease target by it's value.
            findCombinations(arr, idx, target - arr[idx], cl);
            //Backtracking : Remove the recently added element.
            cl.remove(cl.size() - 1);
        }
        //Second Call : We don't pick the element and move on to the next one (idx + 1).
        findCombinations(arr, idx + 1, target, cl);
    }
}
