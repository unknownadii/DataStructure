package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class PrintAllNodesInDescendingOrder {
    public static void main(String[] args) {
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        obj.display(root);
        System.out.println();


        //descending order
        obj.printNodeInDescendingOrder(root);
    }
}
