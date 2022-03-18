package Tree.BinarySearchTree.Traversal;

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class Traversal {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        obj.display(root);

        obj.traversal(root);
    }
}
