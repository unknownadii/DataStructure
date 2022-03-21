package HeapAndPriorityQueue.GenricHeap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GenricPreBuildPriorityQueueUsingHeap {

    //----------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Comparable--------------------------------------------------------------------------------

    //Comparable
    private static class Students implements Comparable<Students> {

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
            return this.rollNo - o.rollNo;// Displaying in Ascending Order on the bases of Roll no when (this.rollno - o.rollno )
            // return  o.rollNo - this.rollNo; //Displaying in Descending Order on the bases of Roll no when (o.rollNo - this.rollNo )
            // return o.marks - this.marks; //Displaying in Descending Order on the bases of marks when (o.marks - this.marks )
            // return this.marks - o.marks; //Displaying in Ascending  Order on the bases of marks when (this.marks - o.marks )
        }

        @Override
        public String toString() {
            return " RollNo :- " + this.rollNo + " Marks :- " + this.marks + " Height :- " + this.height;
        }
    }

//----------------------------------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------Comparator--------------------------------------------------------------------------------

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
