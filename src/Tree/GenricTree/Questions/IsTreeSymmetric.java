package Tree.GenricTree.Questions;

import Tree.GenricTree.GenricTreeImplemented;

public class IsTreeSymmetric {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.linewiseLevelOrderTraversal(root);

        //checking symatric or not node
        System.out.println(obj.isTreeSymmetric(root));
        //if tree is mirror image of itself then it is symmetric also
    }
}
