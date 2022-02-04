package LinkedList.Questions;

import LinkedList.Implementation.LL;
/*
Question link :- https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
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
    }
}
