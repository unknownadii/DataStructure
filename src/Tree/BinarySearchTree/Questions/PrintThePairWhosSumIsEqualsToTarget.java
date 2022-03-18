package Tree.BinarySearchTree.Questions;

import Tree.BinarySearchTree.BinarySearchTreeImplemented;

public class PrintThePairWhosSumIsEqualsToTarget {
    public static void main(String[] args) {
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);


        // Method 1
        obj.printThePairWhosSumIsEqualsToTarget(root,root,10);
        //Method 2
        System.out.println();
        obj.printThePairWhosSumIsEqualsToTarget2(root,10);
        //Method 3 (See the copy for best Understanding )
        System.out.println();
       obj.printThePairWhosSumIsEqualsToTargetBestApproach(root,10);




    }
}
