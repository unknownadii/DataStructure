package Tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
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

    //Size
    public int size(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int totalSize = leftSize + rightSize + 1;
        return totalSize;
    }

    //Maximum Node
    public int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int maxLeft = max(node.left);
        int maxRight = max(node.right);
        int max = Math.max(node.data, Math.max(maxLeft, maxRight));
        return max;
    }

    //Minimum Node
    public int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int minLeft = min(node.left);
        int minRight = min(node.right);
        int min = Math.min(node.data, Math.max(minLeft, minRight));
        return min;
    }

    //Sum
    public int sum(Node node) {
        if (node == null) {
            return 0;
        }
        int ls = sum(node.left);
        int rs = sum(node.right);
        int ts = ls + rs + node.data;
        return ts;
    }

    //Height Of tree
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        int th = Math.max(lh, rh) + 1;
        return th;
    }

    //Traversal (pre ,in and post)
    public void traversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " In Pre Order");
        traversal(node.left);
        System.out.println(node.data + " In InOrder");
        traversal(node.right);
        System.out.println(node.data + " In Post Order");
    }

    //Iterative Traversal (pre ,in and post)
    public void iterativetraversal(Node node) {
        Pair rtp = new Pair(node, 1);
        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        String pre = "";
        String post = "";
        String in = "";
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                pre += top.node.data + " ";
                top.state++;

                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            } else if (top.state == 2) {
                in += top.node.data + " ";
                top.state++;

                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            } else {
                post += top.node.data + " ";
                top.state++;

                st.pop();
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    //Level Order Traversal
    public void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size() > 0) {
            //Adding Tree children Node in Queue
            int qsize = queue.size();
            for (int i = 0; i < qsize; i++) {
                node = queue.remove();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }
}
