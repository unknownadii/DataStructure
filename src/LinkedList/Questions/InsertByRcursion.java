package LinkedList.Questions;

import LinkedList.Implementation.LL;

public class InsertByRcursion {
    public static void main(String[] args) {
        //insert by Recusion
        LL list = new LL();
        list.insertByRecursion(121,0);
        list.insertByRecursion(12,1);
        list.insertByRecursion(11,2);
        list.insertByRecursion(1201,2);
        list.insertByRecursion(1219,2);
        list.insertByRecursion(1291,2);
        list.display();
    }
}
