package HeapAndPriorityQueue.GenricHeap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

// if no parameter is passed during object creation of GenricPriorityQueueUsingHeap
// then default constuctor will call and comparable will implement

// But parameter is passed then Comparator Type will call
class GenricPriorityQueueUsingHeap<T> {

    private ArrayList<T> data;
    Comparator<T> comparator;

    //Constructor GenricPriorityQueueUsingHeap
    public GenricPriorityQueueUsingHeap() {
        data = new ArrayList<>();
        comparator = null;
    }

    //Constructor GenricPriorityQueueUsingHeap with parameter
    public GenricPriorityQueueUsingHeap(Comparator comparator) {
        data = new ArrayList<>();
        comparator = comparator;
    }

    //Add Function
    public void add(T val) {
        data.add(val);
        upHeapify(data.size() - 1);
    }

    //Is i smaller then j
    private boolean isSmaller(int i, int j) {

        if (comparator == null) {
            //Comparable
            Comparable ith = (Comparable) data.get(i);
            Comparable jth = (Comparable) data.get(j);

            if (ith.compareTo(jth) < 0) {
                // less than zero means -ve
                return true;
            } else {
                return false;
            }
        } else {
            //Comparator
            T ith = data.get(i);
            T jth = data.get(j);

            if (comparator.compare(ith, jth) < 0) {
                // less than zero means -ve
                return true;
            } else {
                return false;
            }
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

    //Comparable
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

    //Comparator
    private static class StudentsSortOnBasisOfMarks implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            return s1.marks - s2.marks;
        }
    }

    private static class StudentsSortOnBasisOfHeight implements Comparator<Students> {
        @Override
        public int compare(Students s1, Students s2) {
            return s1.height - s2.height;
        }
    }


    public static void main(String[] args) {

    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------Comparable--------------------------------------------------------------------------------

        //comparable
        PriorityQueue<Students> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Students(3, 5, 170));
        priorityQueue.add(new Students(4, 6, 180));
        priorityQueue.add(new Students(2, 1, 175));
        priorityQueue.add(new Students(1, 4, 172));
        priorityQueue.add(new Students(8, 3, 160));
        priorityQueue.add(new Students(5, 9, 165));
        priorityQueue.add(new Students(10, 7, 140));

        //Displaying by traversing in queue
        System.out.println("Just Displaying All Content");
        for (Students val : priorityQueue) {
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }

        /* Method 2 Displaying

        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.peek());
            priorityQueue.remove();
        }

         */

        System.out.println();
        //Displaying in Ascending Order on the bases of Roll no when (this.rollno - o.rollno )
        System.out.println("Displaying in Ascending Order on the bases of Roll no when (this.rollno - o.rollno )");
        while (priorityQueue.size() > 0) {
            Students val = priorityQueue.remove();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }

       /* Displaying in Descending Order on the bases of Roll no when (o.rollno - this.rollno)
        System.out.println("Displaying in Descending  Order on the bases of Roll no when (this.rollno - o.rollno )");
        while (priorityQueue.size() > 0) {
            Students val = priorityQueue.remove();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }
        */
      /*  Displaying in Descending Order on the bases of marks  when (o.marks - this.marks)
        System.out.println("Displaying in Descending Order on the bases of marks  when (o.marks - this.marks)");
        while (priorityQueue.size() > 0) {
            Students val = priorityQueue.remove();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
         }

       */

        /*  Displaying in Ascending Order on the bases of marks  when ( this.marks-o.marks)
        System.out.println("Displaying in Descending Order on the bases of marks  when (o.marks - this.marks)");
        while (priorityQueue.size() > 0) {
            Students val = priorityQueue.remove();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }
        */
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------Comparator--------------------------------------------------------------------------------


        //Comparator Comparison on Basis of Marks
        PriorityQueue<Students> priorityQueueMComparator = new PriorityQueue<>(new StudentsSortOnBasisOfMarks());

        priorityQueueMComparator.add(new Students(3, 5, 170));
        priorityQueueMComparator.add(new Students(4, 6, 180));
        priorityQueueMComparator.add(new Students(2, 1, 175));
        priorityQueueMComparator.add(new Students(1, 4, 172));
        priorityQueueMComparator.add(new Students(8, 3, 160));
        priorityQueueMComparator.add(new Students(5, 9, 165));
        priorityQueueMComparator.add(new Students(10, 7, 140));

        //  Displaying in Ascending Order on the bases of marks  (s1.marks - s2.marks);
        System.out.println("Displaying in Ascending Order on the bases of marks  when (s1.marks - s2.marks)");
        while (priorityQueueMComparator.size() > 0) {
            Students val = priorityQueueMComparator.remove();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }


        //Comparator Comparison on Basis of Height
        PriorityQueue<Students> priorityQueueHComparator = new PriorityQueue<>(new StudentsSortOnBasisOfHeight());

        priorityQueueHComparator.add(new Students(3, 5, 170));
        priorityQueueHComparator.add(new Students(4, 6, 180));
        priorityQueueHComparator.add(new Students(2, 1, 175));
        priorityQueueHComparator.add(new Students(1, 4, 172));
        priorityQueueHComparator.add(new Students(8, 3, 160));
        priorityQueueHComparator.add(new Students(5, 9, 165));
        priorityQueueHComparator.add(new Students(10, 7, 140));


        System.out.println();
        //  Displaying in Ascending Order on the bases of Height  when (s1.height - s2.height;)
        System.out.println("Displaying in Ascending Order on the bases of Height  when (s1.height - s2.height)");
        while (priorityQueueHComparator.size() > 0) {
            Students val = priorityQueueHComparator.remove();
            System.out.print(" RollNo :- " + val.rollNo);
            System.out.print(" Marks :- " + val.marks);
            System.out.print(" Height:- " + val.height);
            System.out.println();
        }
    }
}
