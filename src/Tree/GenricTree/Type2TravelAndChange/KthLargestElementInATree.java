package Tree.GenricTree.Type2TravelAndChange;

public class KthLargestElementInATree {
    public static void main(String[] args) {
        GenricTreeImplementedTravalAndChange obj = new GenricTreeImplementedTravalAndChange();
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        GenricTreeImplementedTravalAndChange.Node root = obj.contructGenricTree(arr);
        obj.display(root);

        System.out.println();
        System.out.println(obj.kthLargestElement(root, 3));

    }
}
