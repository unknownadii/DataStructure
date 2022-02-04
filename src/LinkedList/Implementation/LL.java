package LinkedList.Implementation;

public class LL {

    private Node head;
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

    public  boolean LLCycle() {
        Node fastPointer = head;
        Node slowPointer = head;
        while (fastPointer!=null && fastPointer.next != null) {
            fastPointer=fastPointer.next.next;//increment of two steps
            slowPointer=slowPointer.next;
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }

}
