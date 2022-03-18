package Tree.BinarySearchTree;

public class BinarySearchTreeImplemented {

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

    //Construct
    public Node construct(int[] arr, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = low + (high - low) / 2;
        int data = arr[mid];
        Node leftConstruct = construct(arr, low, mid - 1);
        Node rightConstruct = construct(arr, mid + 1, high);
        Node temp = new Node(data, leftConstruct, rightConstruct);
        return temp;
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

    //Size
    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return leftSize + rightSize + 1;
    }

    //sum
    public int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        return leftSum + rightSum + node.data;
    }

    //max
    public int max(Node node) {
        //this  bst  is arrange in such way that all min value is belong right most side in  node;
        if (node.right == null) {
            return node.data;
        } else {
            //move down in right side
            return max(node.right);
        }
    }

    //min
    public int min(Node node) {
        //this  bst  is arrange in such way that all min value is belong left most side in  node;
        if (node.left == null) {
            return node.data;
        } else {
            //move down in left side
            return min(node.left);
        }
    }

    //find
    public boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data < data) {
            return find(node.right, data);
        } else if (node.data > data) {
            return find(node.left, data);
        } else {
            return true;
        }
    }
}
