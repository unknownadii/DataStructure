package LinkedList.Questions;

import LinkedList.Questions.TwoPointersFastAndSlow.MiddleOfLL;

public class MergeSortOnLL {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);

        ListNode midNextNode = mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNextNode);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    public ListNode getMid(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        while (s.next != null && s.next.next != null) {
            f = f.next;
            s = s.next.next;
        }
        return f;
    }

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
}
