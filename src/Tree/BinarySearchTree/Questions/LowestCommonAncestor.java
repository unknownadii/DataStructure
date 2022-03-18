package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 99};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        System.out.println();


        System.out.println(obj.lca(root,3,8));
    }
}
