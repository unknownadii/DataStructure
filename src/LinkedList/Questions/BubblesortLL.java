package LinkedList.Questions;

import LinkedList.Implementation.LL;

public class BubblesortLL {
    public static void main(String[] args) {
        LL list =new LL();
        for (int i=10;i>0;i--) {
            list.insertLast(i);
        }
        list.display();
        list.bubbleSort();
        list.display();
    }
}
