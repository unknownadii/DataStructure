package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class AddANode {
    public static void main(String[] args) {
        // Method 1
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 99};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        obj.display(root);
        System.out.println();
        obj.add(root, 230);

        //Adding a node
        obj.display(root);
    }
}
