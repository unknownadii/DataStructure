package Tree.GenricTree.LevelOrderTraversal;

import Tree.GenricTree.GenricTreeImplemented;

/*
10->20->30->50->60->70->80->90->40->100->120->100->
 */
public class NormalLevelOrderTraversal {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.levelOrderTraversal(root);

    }
}
