package LinkedList.Questions.TwoPointersFastAndSlow;

import LinkedList.Implementation.LL;

public class ReverseLLByIteration {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(3);
        list.insertLast(2);
        list.display();
        list.reverseLLByIteration();
        list.display();
    }
}
