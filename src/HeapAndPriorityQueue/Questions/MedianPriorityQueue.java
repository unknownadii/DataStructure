package HeapAndPriorityQueue.Questions;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianPriorityQueue {
    private static PriorityQueue<Integer> left;
    private static PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
        this.left = new PriorityQueue<>(Collections.reverseOrder());
        this.right = new PriorityQueue<>();
    }

    // add elements
    public static void add(int val) {
        if (right.size() > 0 && val > right.peek()) {
            right.add(val);
        } else {
            left.add(val);
        }
        balanceQueue();
    }

    private static void balanceQueue() {
        if (left.size() - right.size() == 2) {
            // it means left have now two value morethan right so remove 1 value and don't exceed the difference
            // between them by 1
            right.add(left.remove());
        } else if (right.size() - left.size() == 2) {
            left.add(right.size());
        }
    }

    // peek
    public static int peek() {
        if (left.size() == 0 && right.size() == 0) {
            return -1;
        } else if (left.size() >= right.size()) {
            return left.peek();
        } else {
            return right.peek();
        }
    }

    //remove
    public static int remove() {
        if (left.size() == 0 && right.size() == 0) {
            return -1;
        } else if (left.size() >= right.size()) {
            return left.remove();
        } else {
            return right.remove();
        }
    }

}

class Main {
    public static void main(String[] args) {
        MedianPriorityQueue queue = new MedianPriorityQueue();

    }
}
