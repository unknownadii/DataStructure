package Tree.BinaryTree;

public class MainBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {50, 60, 70, null, null, 80, 90, null, null, 100, null, null, 110, 120, null, null, 130, null, null};
        BinaryTreeImplemented obj = new BinaryTreeImplemented();
        BinaryTreeImplemented.Node root = obj.construct(arr);
        obj.display(root);
        System.out.println("Size = "+obj.size(root));
        System.out.println("Max = "+obj.max(root));
        System.out.println("Min = "+obj.min(root));
        System.out.println("Sum = "+obj.sum(root));
        System.out.println("Height in edges = "+obj.height(root));

    }
}
