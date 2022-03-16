package Tree.GenricTree.Normal.LevelOrderTraversal;

import Tree.GenricTree.Normal.GenricTreeImplemented;

public class DelimiterMethodOfLevelOrderTraversal {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.delimiterMethodLinewiseLevelOrderTraversal(root);
    }
}
