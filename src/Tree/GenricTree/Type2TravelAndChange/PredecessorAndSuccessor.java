package Tree.GenricTree.Type2TravelAndChange;

/*
           10

  20               30               40

50  60        70    80    90        100

                 110  120

                 Predecessor And Successor of 110 will :-
                 Predecessor = 80;
                 Successor = 120;
                 Predecessor And Successor of 90 will :-
                 Predecessor = 30;
                 Successor = 40;

 */
public class PredecessorAndSuccessor {
    public static void main(String[] args) {
        GenricTreeImplementedTravalAndChange obj = new GenricTreeImplementedTravalAndChange();
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        GenricTreeImplementedTravalAndChange.Node root = obj.contructGenricTree(arr);
        obj.display(root);

        obj.predecessor = null;
        obj.successor = null;
        obj.state = 0;


        //  it will give max ,min ,height ,size
        obj.predecessorAndSuccessor(root, 20);

        System.out.println();
        if (obj.predecessor != null && obj.successor != null) {
            System.out.println("Predecessor= " + obj.predecessor.data);
            System.out.println("Successor= " + obj.successor.data);
        } else {
            System.out.println("Doesn't found any correct match" );
        }
    }
}
