package LinkedList.Implementation;

import LinkedList.Questions.RotateLL_By_K;

public class LL {

    public Node head;
    private Node tail;
    public int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node temp = new Node(val);
        tail.next = temp;
        tail = temp;
        size++;
    }

    public void insertLastByHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        tail = node;//just updating the tail
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0 || head == null) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        if (index > size) {
            System.out.println("Out of Range Index");
            return;
        }
        Node temp = head;//already at 0 index so starting "i" from 1
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public int deleteFirst() {
        if (size == 0 || head == null) {
            System.out.println("No Element To Delete");
            return -1;
        }
        int retVal = head.val;
        head = head.next;
        //if one element is remaining on list
        if (head == null) {
            tail = null;
        }
        size--;
        return retVal;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node temp = getIndex(size - 2);
        int value = tail.val;
        tail = temp;
        tail.next = null;
        size--;
        return value;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node pre = getIndex(index - 1);
        int value = pre.next.val;
        pre.next = pre.next.next;
        return value;
    }

    public Node getIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int find(int value) {
        Node node = head;
        int count = 0;
        while (node != null) {
            if (node.val == value) {
                return count;
            }
            node = node.next;
            count++;
        }
        return -1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public class Node {
        private int val;
        private Node next;

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next) {
            this.val = value;
            this.next = next;
        }
    }

    /*
    QUESTIONS 1 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    public void insertByRecursion(int value, int index) {
        head = helperInsert(value, index, head);
    }

    private Node helperInsert(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = helperInsert(val, index - 1, node.next);
        return node;
    }
    /*
    QUESTIONS 2 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    public void removeDuplicate() {
        Node node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }
       /*
    QUESTIONS 3 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    public static LL mergeTwoSortedLL(LL f, LL s) {
        Node fh = f.head;
        Node sh = s.head;
        LL ans = new LL();
        while (fh != null && sh != null) {
            if (fh.val < sh.val) {
                ans.insertLast(fh.val);
                fh = fh.next;
            } else {
                ans.insertLast(sh.val);
                sh = sh.next;
            }
        }

        while (fh != null) {
            ans.insertLast(fh.val);
            fh = fh.next;
        }
        while (sh != null) {
            ans.insertLast(sh.val);
            sh = sh.next;
        }
        return ans;
    }

     /*
    QUESTIONS 4 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    public boolean LLCycle() {
        Node fastPointer = head;
        Node slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;//increment of two steps
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }

    //It will return the length of the cycle in list
    public int LLCycleLength() {
        Node fastPointer = head;
        Node slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;//increment of two steps
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                Node temp = slowPointer;
                int l = 0;
                do {
                    temp = temp.next;
                    l++;
                } while (temp != slowPointer);
                return l;
            }
        }
        return 0;
    }

    /*
  QUESTIONS 5 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   */
    public Node returnLLCycleStartingNode() {
        int length = 0;
        Node fastPointer = head;
        Node slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;//increment of two steps
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                length = LLCycleLength();
                break;
            }
        }
        if (length == 0) {
            return null;
        }
        //find the Start Node
        Node firstNode = head;
        Node secondNode = head;
        //moving the second node K-times(length of cycle in list) away from first node
        while (length > 0) {
            secondNode = secondNode.next;
            length--;
        }
        while (firstNode != secondNode) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return firstNode; // Or return secondNode;
    }

       /*
  QUESTIONS 6 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
   */

    public void bubbleSort() {
        bubbleSortHelper(size - 1, 0);
    }

    private void bubbleSortHelper(int row, int col) {
        if (row == 0) {
            return;
        }
        if (col < row) {
            Node f = getIndex(col);
            Node s = getIndex(col + 1);
            if (f.val > s.val) {
                //swap
                if (f == head) {
                    head = s;
                    f.next = s.next;
                    s.next = f;
                } else if (s == tail) {
                    Node tailPre = getIndex(col - 1);
                    tailPre.next = s;
                    tail = f;
                    f.next = null;
                    s.next = tail;
                } else {
                    Node pre = getIndex(col - 1);
                    pre.next = s;
                    f.next = s.next;
                    s.next = f;
                }
            }
            bubbleSortHelper(row, col + 1);
        } else {
            bubbleSortHelper(row - 1, 0);
        }
    }

    /*
QUESTIONS 7 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
    public void reverseLLByRecursion(Node temp) {
        if (temp == tail) {
            head = tail;
            return;
        }
        reverseLLByRecursion(temp.next);
        tail.next = temp;
        tail = temp;
        tail.next = null;
    }

    /*
QUESTIONS 8 :- Leetcode
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
    public void reverseLLByIteration() {
        if (size < 2) {
            return;
        }
        Node pre = null;
        Node present = head;
        Node nextPre = head.next;
        while (present != null) {
            present.next = pre;
            pre = present;
            present = nextPre;
            if (nextPre != null) {
                nextPre = nextPre.next;
            }
        }
        head = pre;
    }

    /*
  QUESTIONS 9 :- Leetcode
  ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  */
    public Node reverseLL2(int left, int right) {
        if (left == right) {
            return head;
        }
        Node prev = null;
        Node current = head;
        for (int i = 0; current.next != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }

        Node last = prev;
        Node newEnd = current;
        //reverse between left and right
        Node next = current.next;
        for (int i = 0; current != null && i < right - left + 1; i++) {
            current.next = prev;
            prev = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = current;
        return head;
    }


    //testing
    public void rotateRight(int k) {
        if (k <= 0 || head == null || head.next == null) {
            return ;
        }
        Node last = head;
        int length = 1;
        // count the length
        while (last.next != null) {
            last = last.next;
            length++;
        }

        last.next = head;
        int rotations = k % length;// to avoid the situation when some gives like rotation more than the length of list
        int skip = length - rotations;// skip last "length - rotation nodes"
        Node newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
    }
}
