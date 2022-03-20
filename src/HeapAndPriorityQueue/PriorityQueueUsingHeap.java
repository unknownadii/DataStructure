package HeapAndPriorityQueue;

import java.util.ArrayList;

public class PriorityQueueUsingHeap {

    private ArrayList<Integer> data;

    public PriorityQueueUsingHeap() {
        data = new ArrayList<>();
    }

    //Add Function
    public void add(int val) {
        data.add(val);
        upHeapify(data.size() - 1);
    }

    private void upHeapify(int childIndex) {
        if (childIndex == 0) {
            return;
        }
        int parentIndex = (childIndex - 1) / 2;
        if (data.get(parentIndex) > data.get(childIndex)) {
            swapIndex(parentIndex, childIndex);
            upHeapify(parentIndex);
        }
    }

    private void swapIndex(int parentIndex, int childIndex) {
        int temp = data.get(parentIndex);
        data.set(parentIndex, data.get(childIndex));
        data.set(childIndex, temp);
    }

    //Remove Function
    public void removeValue() {
        if (data.size() == 0) {
            System.out.println("UnderFlow Condition");
        }
        //Step 1:- swap 1st and last index to maintain the logn complexity while removing.
        swapIndex(0, data.size() - 1);
        System.out.println(data.get(data.size() - 1));
        // Step 2 :- Remove the last index value.
        data.remove(data.size() - 1);
        downHeapify(0);
    }

    private void downHeapify(int parentIndex) {
        int temp = parentIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        //checking left index with parent
        if (leftChildIndex < data.size() && data.get(leftChildIndex) < data.get(parentIndex)) {
            temp = leftChildIndex;
        }
        // checking left with right if above condition is true
        // if false then checking it with parent
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex < data.size() && data.get(rightChildIndex) < data.get(parentIndex)) {
            temp = rightChildIndex;
        }
        //temp!=parentIndex if this condition is false that means the parent have high priority than child
        if (temp != parentIndex) {
            swapIndex(parentIndex, temp);
            downHeapify(temp);
        }
    }

    //peek
    public int peek() {
        if (data.size() == 0) {
            System.out.println("underflow condition arises");
            return -1;
        }
        return data.get(0);
    }

    // size
    public int size() {
        return data.size();
    }

}

class Main {
    public static void main(String[] args) {
        PriorityQueueUsingHeap obj = new PriorityQueueUsingHeap();
        //add
        obj.add(2);
        obj.add(3);
        obj.add(6);
        obj.add(1);
        obj.add(7);
        obj.add(9);
        obj.add(8);
        //display
        obj.removeValue();
        obj.removeValue();
        obj.removeValue();
        obj.removeValue();
        obj.removeValue();

        // peek
        System.out.println("Peek :- "+obj.peek());

    }
}
