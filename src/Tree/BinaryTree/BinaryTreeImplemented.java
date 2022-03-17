package Tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
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


//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------Questions---------------------------------------------------------------------------------------------------------------

    // Find a node in a tree
    public boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        boolean leftReturn = find(node.left, data);
        if (leftReturn) {
            return true;
        }
        boolean rightReturn = find(node.right, data);
        if (rightReturn) {
            return true;
        }
        return false;
    }

    //Find Node to root path
    public ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.data == data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> leftList = nodeToRootPath(node.left, data);
        if (leftList.size() != 0) {
            leftList.add(node.data);
            return leftList;
        }
        ArrayList<Integer> rightList = nodeToRootPath(node.right, data);
        if (rightList.size() != 0) {
            rightList.add(node.data);
            return rightList;
        }
        return new ArrayList<>();
    }

    // return nodes
    public ArrayList<Node> nodeToRootPathReturnNode(Node node, int data) {
        if (node == null) {
            return new ArrayList<>();
        }
        if (node.data == data) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        ArrayList<Node> leftList = nodeToRootPathReturnNode(node.left, data);
        if (leftList.size() != 0) {
            leftList.add(node);
            return leftList;
        }
        ArrayList<Node> rightList = nodeToRootPathReturnNode(node.right, data);
        if (rightList.size() != 0) {
            rightList.add(node);
            return rightList;
        }
        return new ArrayList<>();
    }

    //Method 2 Node to root path
    public ArrayList<Integer> path;

    public boolean nodeToRootPathMethod2(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            path.add(node.data);
            return true;
        }
        boolean leftList = nodeToRootPathMethod2(node.left, data);
        if (leftList) {
            path.add(node.data);
            return true;
        }
        boolean rightList = nodeToRootPathMethod2(node.right, data);
        if (rightList) {
            path.add(node.data);
            return true;
        }
        return false;
    }


    //Print k level down all nodes
    public void printKLevelDown(Node node, int k) {
        if (node == null || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.println(node.data);
        }
        printKLevelDown(node.left, k - 1);
        printKLevelDown(node.right, k - 1);
    }


    // Print k nodes away from given node in binary tree
    public void printKNodesAwayFromGivenNode(Node node, int data, int k) {
        ArrayList<Node> path = nodeToRootPathReturnNode(node, data);
        printKLevelDown(path.get(0), k);
        for (int i = 1; i < path.size(); i++) {
            Node prev = path.get(i - 1);
            Node curr = path.get(i);

            if (i < k) {
                if (prev == curr.left) {
                    printKLevelDown(curr.right, k - i - 1);
                } else {
                    printKLevelDown(curr.left, k - i - 1);
                }
            } else if (i == k) {
                System.out.println(curr.data);
            } else {
                break;
            }
        }
    }


    // print path from leaf to root when the sum of all nodes in path is between in range (l0-l1)
    public static void pathToLeafFromRootInSumRange(Node node, String path, int sum, int lo, int hi) {
        if (node.left != null && node.right != null) {
            pathToLeafFromRootInSumRange(node.left, path + node.data + " ", sum + node.data, lo, hi);
            pathToLeafFromRootInSumRange(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.left != null) {
            pathToLeafFromRootInSumRange(node.left, path + node.data + " ", sum + node.data, lo, hi);
        } else if (node.right != null) {
            pathToLeafFromRootInSumRange(node.right, path + node.data + " ", sum + node.data, lo, hi);
        } else {
            path += node.data;
            sum += node.data;

            if (sum >= lo && sum <= hi) {
                System.out.println(path);
            }
        }
    }

    //Method 2
    public void pathToLeafFromRootInSumRange2(Node node, int low, int high, int sum, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            path += node.data;
            sum += node.data;
            if (sum >= low && sum <= high) {
                System.out.println(path);
            }
            return;
        }
        pathToLeafFromRootInSumRange2(node.left, low, high, sum + node.data, path + node.data + " ");
        pathToLeafFromRootInSumRange2(node.right, low, high, sum + node.data, path + node.data + " ");
    }


    //Transform Tree InTo Left Cloned Tree
    public Node transformTreeInToLeftClonedTree(Node node) {
        if (node == null) {
            return null;
        }
        Node returnLeft = transformTreeInToLeftClonedTree(node.left);
        Node returnRight = transformTreeInToLeftClonedTree(node.right);
        Node temp = new Node(node.data, returnLeft, null);
        node.left = temp;
        node.right = returnRight;
        return node;
    }


    //Transform Left Cloned Tree To Normal Tree
    public Node transformLeftClonedTreeToNormalTree(Node node) {
        if (node == null) {
            return null;
        }
        node.left = transformLeftClonedTreeToNormalTree(node.left.left);
        node.right = transformLeftClonedTreeToNormalTree(node.right);
        return node;
    }


    //Remove all leaf node from Tree
    public Node removeAllLeafNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null && node.right == null) {
            return null;
        }
        node.left = removeAllLeafNode(node.left);
        node.right = removeAllLeafNode(node.right);
        return node;
    }


    //Print All single child node in a tree
    public void printAllSingleChildNode(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null  && node.right !=null) {
            System.out.print(node.right.data + " child <- parent "+node.data +" ");
        }
        else if ( node.right ==null && node.left != null ) {
            System.out.print(node.left.data + " child <- parent "+node.data +" ");
        }
        printAllSingleChildNode(node.left);
        printAllSingleChildNode(node.right);
    }

    //Method2
    public void printAllSingleChildNode2(Node node,Node parent) {
        if (node == null) {
            return;
        }
        if (parent !=null && parent.left==null && parent.right == node) {
            System.out.print(node.data + " child <- parent " + parent.data +" ");
        }
        else if (parent !=null && parent.right==null && parent.left == node) {
            System.out.print(node.data + " child <- parent " + parent.data +" ");
        }
        printAllSingleChildNode2(node.left,node);
        printAllSingleChildNode2(node.right,node);
    }

}
