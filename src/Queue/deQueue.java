package Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class deQueue {
    public static void main(String[] args) {
       Deque<Integer> deque = new ArrayDeque<Integer>();

        deque.add(89);
        deque.addLast(78);
        deque.removeFirst();
        // etc etc
    }
}
