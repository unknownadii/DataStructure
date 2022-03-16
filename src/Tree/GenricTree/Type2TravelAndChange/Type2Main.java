package Tree.GenricTree.Type2TravelAndChange;

/*
           10

  20               30               40

50  60        70    80    90        100

                 110  120

 */
public class Type2Main {
    public static void main(String[] args) {
        GenricTreeImplementedTravalAndChange obj = new GenricTreeImplementedTravalAndChange();
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        GenricTreeImplementedTravalAndChange.Node root = obj.contructGenricTree(arr);
        obj.display(root);

        obj.max = Integer.MIN_VALUE;
        obj.min = Integer.MAX_VALUE;
        obj.height = 0;
        obj.size = 0;

        //  it will give max ,min ,height ,size
        obj.multiSolver(root, 0);

        System.out.println();
        System.out.println("Size= " + obj.size);
        System.out.println("Min= " + obj.min);
        System.out.println("Max= " + obj.max);
        System.out.println("Height = " + obj.height);
    }
}
