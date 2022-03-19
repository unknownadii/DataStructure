package HashMapAndHashSet.PreBuildHashmap;

import java.util.HashMap;
import java.util.Scanner;

public class PrintCommonElementsInTwoArraysRepetationAllowed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr1[] = {1, 2, 2, 2, 3, 4, 5, 6, 6, 7, 8, 9};
        int[] arr2 = {2, 2, 4, 6, 6, 6, 8, 0, 44, 44, 22};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr1) {
            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }
        for (int val : arr2) {
            if (map.containsKey(val) && map.get(val) > 0) {
                System.out.println(val);
                map.put(val,map.get(val) - 1);
            }
        }
    }
}
