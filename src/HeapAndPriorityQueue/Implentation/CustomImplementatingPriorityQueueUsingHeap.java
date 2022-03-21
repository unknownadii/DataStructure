package HeapAndPriorityQueue.Implentation;

import java.util.ArrayList;

class PriorityQueueUsingHeap {

    private ArrayList<Integer> data;

    public PriorityQueueUsingHeap() {
        data = new ArrayList<>();
    }

    //Add Function
    // (logn)-> for 1 element adding
    // nlogn -> for n elements it will takes 0(nlogn) time complexity
    public void add(int val) {
        data.add(val);
        upHeapify(data.size() - 1);
    }

    // Add Function
    // (o(n)) time complexity -> for n element addition
    public void addLinearly(int arr[]) {
        data = new ArrayList<>();
        // add all value firstly
        for (int val : arr) {
            data.add(val);
        }
        for (int i = (data.size() / 2) - 1; i >= 0; i--) {
            downHeapify(i);
        }
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
        int parent = data.get(parentIndex);
        int child = data.get(childIndex);

        data.set(parentIndex, child);
        data.set(childIndex, parent);
    }

    //Remove Function
    public int removeValue() {
        if (this.size() == 0) {
            System.out.println("UnderFlow Condition");
        }
        //Step 1:- swap 1st and last index to maintain the logn complexity while removing.
        swapIndex(0, data.size() - 1);
        // Step 2 :- Remove the last index value.
        int val = data.remove(data.size() - 1);
        downHeapify(0);
        return val;
    }

    private void downHeapify(int parentIndex) {
        int temp = parentIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        //checking left index with parent
        if (leftChildIndex < data.size() && data.get(leftChildIndex) < data.get(temp)) {
            temp = leftChildIndex;
        }
        // checking left with right if above condition is true
        // if false then checking it with parent
        // and temp variable will store it
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex < data.size() && data.get(rightChildIndex) < data.get(temp)) {
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
        if (this.size() == 0) {
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
        //add nlogn
        int arr[] = {1, 2, 4, 3, 5, 7, 4, 6, 34, 8, 0};
        int arr2[] = {12, 25, 44, 37, 215, 57, 49, 65, 34, 18, 60};
        for (int i = 0; i < arr.length; i++) {
            obj.add(arr[i]);
        }
        //display
        int size = obj.size();
        for (int i = 0; i < size; i++) {
            System.out.println(obj.removeValue());
            System.out.println("Size => " + obj.size());
        }

        System.out.println();
        // adding 0(n)
        obj.addLinearly(arr2);

        System.out.println("Size => " + obj.size());
        //display
        int sizelinear = obj.size();
        for (int i = 0; i < sizelinear; i++) {
            System.out.println(obj.removeValue());
            System.out.println("Size => " + obj.size());
        }
        System.out.println("Size => " + obj.size());


    }
}
