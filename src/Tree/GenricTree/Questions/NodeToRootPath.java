package Tree.GenricTree.Questions;

import Tree.GenricTree.GenricTreeImplemented;

import java.util.ArrayList;

/*
                   10

  20               30               40

50  60        70    80    90        100

                 110 120

if node is 110 then path will be:-
output :- [110,80,30,10]

 */
public class NodeToRootPath {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};

        GenricTreeImplemented obj = new GenricTreeImplemented();
        GenricTreeImplemented.Node root = obj.contructGenricTree(arr);
        obj.linewiseLevelOrderTraversal(root);


        ArrayList<Integer> list = obj.node2RootPath(root,110);

        System.out.println(list);


    }
}
