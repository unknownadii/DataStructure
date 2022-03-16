package Tree.GenricTree.Type2TravelAndChange;
/*
                 10

  20               30               40

50  60        70    80    90        100

                 110  120

 */
public class DiameterOfTree {
    public static void main(String[] args) {
        GenricTreeImplementedTravalAndChange obj = new GenricTreeImplementedTravalAndChange();
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        GenricTreeImplementedTravalAndChange.Node root = obj.contructGenricTree(arr);
        obj.display(root);

        //  it will give max ,min ,height ,size
        obj.diameterOfTree(root);

        System.out.println("Diameter ->" + obj.diameter);

    }
}
