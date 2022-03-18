package Tree.BinarySearchTree;

public class BinarySearchTreeImplementedMethod2 {

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // For the root node
    public Node root;

    public BinarySearchTreeImplementedMethod2() {
        root = null;
    }

    //Inserting data in Tree
    public void insert(int data) {
        Node node = new Node(data, null, null);

        //if the node is root or not ?
        if (root == null) {
            root = node;
            return;
        } else {
            Node current = root;
            Node parent = null;

            // traversing in whole bst for inserting the data on right place
            while (true) {
                parent = current;
                if (data < current.data) {
                    // goto the left path
                    current = current.left;
                    if (current == null) {
                        // It means current is at null it is parent is leaf node so add node here and break the loop
                        parent.left = node;
                        break;
                    }
                } else {
                    // goto the right path
                    current = current.right;
                    if (current == null) {
                        // It means current is at null it is parent is leaf node so add node here and break the loop
                        parent.right = node;
                        break;
                    }
                }
            }
        }

    }

    //Display
    public void display(Node node) {
        if (node == null) {
            return;
        }
        String str = " ";
        str += node.left == null ? "." : node.left.data + " ";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}
