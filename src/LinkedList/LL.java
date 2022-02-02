package LinkedList;

import javax.management.StandardMBean;

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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
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

        Node temp = getIndex(size-2);
        int value = tail.val;
        tail =temp;
        tail.next =null;
        size--;
        return value;
    }

    public Node getIndex(int index) {
        Node node = head;
        for (int i=0;i<index;i++) {
            node=node.next;
        }
        return node;
    }
    class Node {
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

}
