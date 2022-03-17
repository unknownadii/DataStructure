package Tree.BinaryTree.Questions;

import Tree.BinaryTree.BinaryTreeImplemented;

import java.util.ArrayList;

public class FindNodeToRootPath {
    public static void main(String[] args) {
        Integer[] arr = {50, 60, 70, null, null, 80, 90, null, null, 100, null, null, 110, 120, null, null, 130, null, null};
        BinaryTreeImplemented obj = new BinaryTreeImplemented();
        BinaryTreeImplemented.Node root = obj.construct(arr);

        obj.path = new ArrayList<>();
        System.out.println(obj.nodeToRootPath(root, 90));
        System.out.println(obj.nodeToRootPathMethod2(root, 90));
        System.out.println(obj.path);
    }
}
