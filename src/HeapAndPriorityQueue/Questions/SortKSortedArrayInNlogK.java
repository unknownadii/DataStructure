package HeapAndPriorityQueue.Questions;

import java.util.PriorityQueue;

public class SortKSortedArrayInNlogK {
    public static void main(String[] args) {
        int arr[] = {1, 8, 2, 9, 4, 2, 7, 5, 8, 5};
        int k = 3;

        // now make the length of queue up to k by adding k elements from array
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            System.out.println(pq.remove());
            pq.add(arr[i]);
        }

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
