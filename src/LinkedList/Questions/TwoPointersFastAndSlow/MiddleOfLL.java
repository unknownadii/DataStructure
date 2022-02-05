package LinkedList.Questions.TwoPointersFastAndSlow;

import LinkedList.Implementation.LL;

import java.util.LinkedList;

public class MiddleOfLL {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode middleNode(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (s != null && s.next != null) {
            f = f.next;
            s = s.next.next;
        }
        return f;

    }
}

