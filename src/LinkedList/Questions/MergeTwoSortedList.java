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

/*
Answer on Leetcode
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode preHead = new ListNode();
    ListNode last = preHead;

    while(l1 != null && l2 != null) {
        if(l1.val > l2.val) {
            last.next = l2;
            l2 = l2.next;
        } else {
            last.next = l1;
            l1 = l1.next;
        }
        last = last.next;
    }

    if(l1 == null) {
        last.next = l2;
    } else {
        last.next = l1;
    }

    return preHead.next;
}
}
 */
