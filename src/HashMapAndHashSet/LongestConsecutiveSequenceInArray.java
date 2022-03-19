package HashMapAndHashSet;

import java.util.HashMap;

public class LongestConsecutiveSequenceInArray {
    public static void main(String[] args) {
        int arr[] = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};


        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int val : arr) {
            //initially all value will be true
            map.put(val, true);
        }

        for (int val : arr) {
            if (map.containsKey(val - 1)) {
                //checking if the consecutive value is present of the val is present or not
                // if not then put false at the of val
                map.put(val, false);
            }
        }

        int mInitialConsecutiveValue = 0, mConsecutiveValueLength = 0;
        for (int val : arr) {
            if (map.get(val)) {
                int initialConsecutiveValue = val , consecutiveValueLength = 1;

                // now check val consecutive elements in arr
                while (map.containsKey(initialConsecutiveValue + consecutiveValueLength)) {
                    // count the length of sequence
                    consecutiveValueLength++;
                }

                //now check for highest sequence
                if (consecutiveValueLength > mConsecutiveValueLength) {
                    mInitialConsecutiveValue = initialConsecutiveValue;
                    mConsecutiveValueLength = consecutiveValueLength;
                }
            }
        }
        for (int i=0 ;i<mConsecutiveValueLength ;i++) {
            System.out.println(mInitialConsecutiveValue + i);
        }
    }
}
