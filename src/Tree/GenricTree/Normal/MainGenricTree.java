package Tree.GenricTree.Normal;

import Tree.GenricTree.Normal.GenricTreeImplemented;

public class MainGenricTree {
    public  static void main(String[] args) {
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);

        System.out.println(obj.size(root));

       obj.display(root);

        System.out.println(obj.maxValue(root));
        System.out.println(obj.minValue(root));

        System.out.println(obj.heightInEdges(root));
        System.out.println(obj.heightInNodes(root));

        System.out.println(obj.find(root, 1080));
        GenricTreeImplemented.Node temp = obj.findNode(root, 100);
        if (temp != null) {
            System.out.println("Found -> " + temp.data);
        } else {
            System.out.println("Not Found");
        }
        obj.traversal(root);

    }
}
