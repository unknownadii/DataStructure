package Tree.GenricTree.Questions;

import Tree.GenricTree.GenricTreeImplemented;

/*
           10

  20               30               40

50  60        70    80    90        100

                 110 120

                 if two nodes is 50 and 120 then
                 output :- 10
                 if two nodes is 110 and 90 then
                 output :- 30
                 if two nodes is 80 and 120 then
                 output :- 80
 */
public class LCA_lowest_comman_anciester {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.linewiseLevelOrderTraversal(root);

        //lowest comman anciester
        System.out.println(obj.lca(root,50,90));
    }
}
