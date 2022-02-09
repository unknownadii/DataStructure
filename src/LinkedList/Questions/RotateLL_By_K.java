package LinkedList.Questions;

import LinkedList.Implementation.LL;

public class RotateLL_By_K {
    public static void main(String[] args) {
        LL list =  new LL();
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.display();
        list.rotateRight(4);
        list.display();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        int length = 1;// count the length
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        ListNode newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
