package LinkedList.Implementation;

public class DoublyLL {

    Node head;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;
        if (head == null) {
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.pre = last;

    }


    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.pre = p;
        if (node.next != null) {
            node.next.pre = node;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void displayReverse() {
        System.out.println("Print In Reverse");
        Node temp = head;
        Node last = null;
        while (temp != null) {
            last = temp;
            temp = temp.next;
        }
        while (last != null) {
            System.out.print(last.val + "->");
            last = last.pre;
        }
        System.out.println("START");
    }

    private class Node {
        private int val;
        private Node next;
        private Node pre;

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, Node next, Node Pre) {
            this.val = value;
            this.next = next;
            this.pre = Pre;
        }
    }
}
