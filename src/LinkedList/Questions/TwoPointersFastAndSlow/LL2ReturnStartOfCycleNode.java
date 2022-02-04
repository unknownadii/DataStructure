package LinkedList.Questions.TwoPointersFastAndSlow;

import LinkedList.Implementation.LL;

public class LL2ReturnStartOfCycleNode {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);
        list.display();
        System.out.println(list.LLCycle());
        System.out.println(list.LLCycleLength());//
        System.out.println(list.returnLLCycleStartingNode());
    }
}
