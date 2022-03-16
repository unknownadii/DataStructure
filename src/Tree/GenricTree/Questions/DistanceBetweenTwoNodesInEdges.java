package Tree.GenricTree.Questions;

import Tree.GenricTree.GenricTreeImplemented;

/*
           10

  20               30               40

50  60        70    80    90        100

                 110  120

                 distance between 70 and 120 is :-
                 output :- 3

 */
public class DistanceBetweenTwoNodesInEdges {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.linewiseLevelOrderTraversal(root);

        //distance between two nodes
        System.out.println(obj.distanceBetweenTwoNodes(root,70,120));
    }
}
