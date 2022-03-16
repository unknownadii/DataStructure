package Tree.GenricTree.Normal.Questions;

import Tree.GenricTree.Normal.GenricTreeImplemented;

public class AreTreesMirrorInShape {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        int[] arr3 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        int[] arr2 = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        GenricTreeImplemented.Node root2 = obj.contructGenricTree(arr2);
        GenricTreeImplemented.Node root3 = obj.contructGenricTree(arr3);
        obj.linewiseLevelOrderTraversal(root);
        obj.linewiseLevelOrderTraversal(root2);

        //distance between two nodes
        System.out.println(obj.areTreeMirrorInShape(root, root2));
        System.out.println(obj.areTreeMirrorInShape(root3, root2));
    }
}
