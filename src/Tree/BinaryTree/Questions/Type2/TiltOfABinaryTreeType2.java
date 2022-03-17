package Tree.BinaryTree.Questions.Type2;

import Tree.BinaryTree.BinaryTreeImplemented;

public class TiltOfABinaryTreeType2 {
    public static void main(String[] args) {
        Integer[] arr = {50, 60, 80, null, null, 90, 10, null, null, null, 70, 110, null, null, null};
        BinaryTreeImplemented obj = new BinaryTreeImplemented();
        BinaryTreeImplemented.Node root = obj.construct(arr);
        obj.display(root);

        obj.tilt(root);
        System.out.println(obj.tiltTree);

    }
}
