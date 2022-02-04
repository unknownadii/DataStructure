package LinkedList.Questions;

import LinkedList.Implementation.LL;

public class RemoveDuplicateNodes {
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
        list.removeDuplicate();
        list.display();
    }

}
