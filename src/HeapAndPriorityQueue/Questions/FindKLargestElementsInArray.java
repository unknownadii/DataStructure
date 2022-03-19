package HeapAndPriorityQueue.Questions;

import java.util.PriorityQueue;

public class FindKLargestElementsInArray {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int arr[] = {1, 8, 2, 9, 4, 2, 7, 5, 8, 5};
        int k = 3;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                //firstly add k elements in queue
                priorityQueue.add(arr[i]);
            } else {
                // now add any further value in queue if it greater than elements in queue
                if (arr[i] > priorityQueue.peek()) {
                    priorityQueue.remove();
                    priorityQueue.add(arr[i]);
                }
            }
        }

        // now print the  K highest elements
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.remove());
        }
    }
}
