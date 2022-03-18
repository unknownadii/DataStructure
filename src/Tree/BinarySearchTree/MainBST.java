package Tree.BinarySearchTree;

public class MainBST {
    public static void main(String[] args) {

        /*
        For Method 2
        BinarySearchTreeImplementedMethod2 ob = new BinarySearchTreeImplementedMethod2();
        ob.insert(40);
        ob.insert(50);
        ob.insert(10);
        ob.insert(20);
        ob.insert(60);
        ob.insert(30);
        ob.insert(90);
        ob.insert(80);
        ob.insert(70);
        ob.insert(100);
        ob.display(ob.root);
         */

        // Method 1
        BinarySearchTreeImplemented obj = new BinarySearchTreeImplemented();
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 99};
        BinarySearchTreeImplemented.Node root = obj.construct(arr, 0, arr.length - 1);
        obj.display(root);
        System.out.println(obj.size(root));
        System.out.println(obj.sum(root));
        System.out.println(obj.max(root));
        System.out.println(obj.min(root));
        System.out.println(obj.find(root,7));


    }
}
