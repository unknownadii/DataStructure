package LinkedList;

public class Main {
    public static void main(String[] args) {

        /*
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
        list.insert(22, 100);
        list.insert(22, 3);
        list.display();

        //delete
        System.out.println(list.deleteFirst());
        list.display();
        System.out.println(list.deleteLast());
        list.display();
        System.out.println(list.delete(2));
        list.display();

        //find
        System.out.println(list.find(129));
         */

       /* DoublyLL list = new DoublyLL();
        list.insertFirst(33);
        list.insertFirst(12);
        list.insertFirst(21);
        list.insertFirst(56);
        list.insertLast(99);
        list.insert(21,23);
        list.display();
        list.displayReverse();

        */

        CircularLL list = new CircularLL();
        list.insert(23);
        list.insert(3);
        list.insert(19);
        list.insert(75);
        list.display();
        list.delete(19);
        list.display();
    }
}
