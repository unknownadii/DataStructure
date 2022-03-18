package Tree.BinarySearchTree.Questions;

//Replace the node with sum of the node which is greater than that node

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class ReplaceNodesWithSumOfNodes {
    public static void main(String[] args) {
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 99};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        obj.display(root);
        obj.printNodeInAscendingOrder(root);
        obj.printNodeInDescendingOrder(root);
        System.out.println();

        //Adding a node
        obj.replaceNodesWithSumOfNodes(root);
        obj.display(root);
        obj.printNodeInAscendingOrder(root);
        obj.printNodeInDescendingOrder(root);
    }
}
