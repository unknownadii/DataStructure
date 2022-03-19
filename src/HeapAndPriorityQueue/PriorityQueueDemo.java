package HeapAndPriorityQueue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int arr[] = {1, 8, 2, 9, 4, 2, 7, 5, 8, 5};
        // Adding o(nlogn) log-> add() ,n -> loop repetation
        for (int val : arr) {
            priorityQueue.add(val);
        }
        System.out.println(priorityQueue);
        // peek o(1)
        System.out.println(priorityQueue.peek());
        // Deletion o(nlogn)
        while (priorityQueue.size() > 0) {
            System.out.print(priorityQueue.peek() + " ");
            priorityQueue.remove();
        }
    }
}
