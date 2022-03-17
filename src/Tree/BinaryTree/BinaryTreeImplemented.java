package Tree.BinaryTree;

import java.util.Stack;

public class BinaryTreeImplemented {
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

    public class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    // Contruct binary Tree
    //Note here we are using Integer type of array not int type
    // so Integer types of array are capable of storing null  value also
    // while int type of array stores only number type of value but for identification as a replacement for null we can
    // use -1 also in int type of array
    public Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rootPair);

        int i = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                i++;
                if (arr[i] != null) {
                    Node leftNode = new Node(arr[i], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                i++;
                if (arr[i] != null) {
                    Node rightNode = new Node(arr[i], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 1);
                    st.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                st.pop();
            }
        }
        return root;
    }

    //Display Binary Tree

    public void display(Node node) {
        if (node == null) {
            return;
        }
        String str = "";
        str += node.left == null ? "." : node.left.data + " ";
        str += "<-" + node.data + "->";
        str += node.right == null ? "." : node.right.data + " ";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}
