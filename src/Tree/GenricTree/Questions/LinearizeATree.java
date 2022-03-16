package Tree.GenricTree.Questions;

import Tree.GenricTree.GenricTreeImplemented;

/*
Convert From this tree to
                   10

  20               30               40

50  60        70    80    90        100

                 100 120

To This Type OF tree in a linear way
10
20
50
60
30
70
80
100
120
90
40
100

 */
public class LinearizeATree {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.linewiseLevelOrderTraversal(root);

        //  O(n^2)
        obj.linearizeOfGenricTree(root);
        //O(n)
       //obj.linearizeOfGenricTreeMethod2(root);


        System.out.println();
        obj.linewiseLevelOrderTraversal(root);
    }
}
