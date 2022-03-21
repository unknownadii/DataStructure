package HeapAndPriorityQueue.GenricHeap;

import java.util.ArrayList;

class GenricPriorityQueueUsingHeap<T> {

    private ArrayList<T> data;

    public GenricPriorityQueueUsingHeap() {
        data = new ArrayList<>();
    }

    //Add Function
    public void add(T val) {
        data.add(val);
        upHeapify(data.size() - 1);
    }

    //Is i smaller then j
    private boolean isSmaller(int i, int j) {
        //we are using Comparable because we don't the type of value that is stored on  ith and jth index.
        //by using Comaparble we comapare two elements with compareTo() and return the response in :-
        // +ve = if number is greater
        // -ve if the is smaller
        // 0 if both are equal

        Comparable ith = (Comparable) data.get(i);
        Comparable jth = (Comparable) data.get(j);

        if (ith.compareTo(jth) < 0) {
            // less than zero means -ve
            return true;
        } else {
            return false;
        }
    }

    private void upHeapify(int childIndex) {
        if (childIndex == 0) {
            return;
        }
        int parentIndex = (childIndex - 1) / 2;
        if (isSmaller(childIndex, parentIndex) == true) {
            swapIndex(parentIndex, childIndex);
            upHeapify(parentIndex);
        }
    }

    private void swapIndex(int parentIndex, int childIndex) {
        T parent = data.get(parentIndex);
        T child = data.get(childIndex);

        data.set(parentIndex, child);
        data.set(childIndex, parent);
    }

    //Remove Function
    public T removeValue() {
        if (this.size() == 0) {
            System.out.println("UnderFlow Condition");
            return null;
        }
        //Step 1:- swap 1st and last index to maintain the logn complexity while removing.
        swapIndex(0, data.size() - 1);
        // Step 2 :- Remove the last index value.
        T val = data.remove(data.size() - 1);
        downHeapify(0);
        return val;
    }

    private void downHeapify(int parentIndex) {
        int temp = parentIndex;
        int leftChildIndex = 2 * parentIndex + 1;
        //checking left index with parent
        if (leftChildIndex < data.size() && isSmaller(leftChildIndex, temp)) {
            temp = leftChildIndex;
        }
        // checking left with right if above condition is true
        // if false then checking it with parent
        // and temp variable will store it
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex < data.size() && isSmaller(rightChildIndex, temp)) {
            temp = rightChildIndex;
        }
        //temp!=parentIndex if this condition is false that means the parent have high priority than child
        if (temp != parentIndex) {
            swapIndex(parentIndex, temp);
            downHeapify(temp);
        }

    }

    //peek
    public T peek() {
        if (this.size() == 0) {
            System.out.println("underflow condition arises");
            return null;
        }
        return data.get(0);
    }

    // size
    public int size() {
        return data.size();
    }

}

class Main {

    static class Students implements Comparable<Students> {
        int rollNo;
        int marks;
        int height;

        public Students(int rollNo, int marks, int height) {
            this.rollNo = rollNo;
            this.marks = marks;
            this.height = height;
        }

        @Override
        public int compareTo(Students o) {
            // return this.rollNo - o.rollNo; Displaying in Ascending Order on the bases of Roll no when (this.rollno - o.rollno )
            // return  o.rollNo - this.rollNo; //Displaying in Descending Order on the bases of Roll no when (o.rollNo - this.rollNo )
            // return o.marks - this.marks; //Displaying in Descending Order on the bases of marks when (o.marks - this.marks )
            return this.marks - o.marks; //Displaying in Ascending  Order on the bases of marks when (this.marks - o.marks )
        }
    }


    public static void main(String[] args) {
        GenricPriorityQueueUsingHeap<Students> obj = new GenricPriorityQueueUsingHeap();

        obj.add(new Students(3, 5, 170));
        obj.add(new Students(4, 6, 180));
        obj.add(new Students(2, 1, 175));
        obj.add(new Students(1, 4, 172));
        obj.add(new Students(8, 3, 160));
        obj.add(new Students(5, 9, 165));
        obj.add(new Students(10, 7, 140));

        System.out.println("Displaying in Descending Order on the bases of marks  when (o.marks - this.marks)");
        while (obj.size() > 0) {
            Students val = obj.removeValue();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }
    }
}
