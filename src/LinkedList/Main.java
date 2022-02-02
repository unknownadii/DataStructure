package LinkedList;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(33);
        list.insertFirst(12);
        list.insertFirst(21);
        list.insertFirst(56);
        list.display();
        list.insertLast(99);
        list.display();
        list.insertLastByHead(100);
        list.display();
        list.insert(22,100);
        list.insert(22,3);
        list.display();
    }
}
