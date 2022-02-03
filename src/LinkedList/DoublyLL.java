package LinkedList;

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
        while (last!=null) {
            System.out.print(last.val+"->");
            last= last.pre;
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
