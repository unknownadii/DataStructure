package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTreeImplemented;

public class PrintAllSingleChildNodeInTree {
    public static void main(String[] args) {
        Integer[] arr = {50,60,80,null,null,90,10,null,null,null,70,110,null,null,null};
        BinaryTreeImplemented obj = new BinaryTreeImplemented();
        BinaryTreeImplemented.Node root = obj.construct(arr);
        obj.display(root);

        obj.printAllSingleChildNode2(root, null);
        System.out.println();
        obj.printAllSingleChildNode(root);

    }
}
