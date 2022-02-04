package LinkedList.Questions;

import LinkedList.Implementation.LL;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        LL list1 = new LL();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(15);
        LL list2 = new LL();
        list2.insertLast(11);
        list2.insertLast(12);
        list2.insertLast(13);

        LL ans = LL.mergeTwoSortedLL(list1,list2);
        ans.display();
    }
}
