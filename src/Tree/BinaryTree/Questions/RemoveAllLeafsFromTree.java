package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTreeImplemented;

public class RemoveAllLeafsFromTree {
    public static void main(String[] args) {
        Integer[] arr = {50, 60, 70, null, null, 80, 90, null, null, 100, null, null, 110, 120, null, null, 130, null, null};
        BinaryTreeImplemented obj = new BinaryTreeImplemented();
        BinaryTreeImplemented.Node root = obj.construct(arr);
        obj.display(root);

        obj.transformTreeInToLeftClonedTree(root);
        obj.display(root);
    }
}
