package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class PrintNodesWhichIsInRange {
    public static void main(String[] args) {
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 99};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        obj.display(root);
        System.out.println();

        obj.printAllNodeInRange(root,3,8);
        System.out.println();
        obj.printAllNodeInRange2(root,3,8);

    }
}
