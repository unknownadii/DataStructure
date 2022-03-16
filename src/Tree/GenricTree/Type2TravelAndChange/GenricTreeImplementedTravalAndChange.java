package Tree.GenricTree.Type2TravelAndChange;

import java.util.*;

public class GenricTreeImplementedTravalAndChange {
    public GenricTreeImplementedTravalAndChange() {
    }

    public class Node {
        int data;
        ArrayList<Node> childrenNode = new ArrayList<>();

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }
    }

    public Node contructGenricTree(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = arr[i];
                if (st.size() > 0) {
                    st.peek().childrenNode.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);
            }
        }
        return root;
    }

    public void display(Node node) {
        // Display Own Value
        String str = node.data + "->";

        // Display it's own children value
        for (Node child : node.childrenNode) {
            str = str + child.data + ",";
        }
        str += ";";
        System.out.println(str);

        // Saying childrens to call it's children to display their answer
        for (Node child : node.childrenNode) {
            display(child);
        }
    }


    //MultiSolver Method
    public int size, min, max, height;

    public void multiSolver(Node node, int depth) {
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        for (Node child : node.childrenNode) {
            multiSolver(child, depth + 1);
        }
    }


    //Predecessor and Successor
    Node predecessor;
    Node successor;
    int state;

    public void predecessorAndSuccessor(Node node, int data) {
        if (state == 0) {
            if (node.data == data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state++;
        }
        for (Node child : node.childrenNode) {
            predecessorAndSuccessor(child, data);
        }
    }


    //Ceil And Floor Of A Number

    public int ceil, floor;

    public void ceilAndFloor(Node node, int data) {
        if (node.data > data) {
            if (node.data < ceil) {
                ceil = node.data;
            }
        }
        if (node.data < data) {
            if (node.data > floor) {
                floor = node.data;
            }
        }
        for (Node child : node.childrenNode) {
            ceilAndFloor(child, data);
        }
    }


    //Kth Largest Element In A Tree

    public int kthLargestElement(Node node, int k) {
        int data = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            ceilAndFloor(node, data);
            data = floor;
            floor = Integer.MIN_VALUE;
        }
        return data;
    }


/*
========================================================================================================================
========================================================================================================================
                                                     Traversal
 */

    // traversal in Genric tree
    public void traversal(Node node) {
        System.out.println("Node Pre -> " + node.data);
        for (Node child : node.childrenNode) {
            System.out.println("Edge Pre -> " + node.data + "-" + child.data);
            traversal(child);
            System.out.println("Edge Post -> " + node.data + "-" + child.data);
        }
        System.out.println("Node Post -> " + node.data);
    }

    //Level Order Traversal

    // 1. Normal Level Order Traversal
    public void levelOrderTraversal(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        //root node
        queue.add(node);
        while (queue.size() > 0) {
            Node temp = queue.remove();
            System.out.print(temp.data + "->");
            // Adding all children of Node temp
            for (Node child : temp.childrenNode) {
                queue.add(child);
            }
        }
        System.out.println();
    }

    // 2. Line wise Level Order Traversal
    public void linewiseLevelOrderTraversal(Node node) {
        Queue<Node> mqueue = new ArrayDeque<>();
        mqueue.add(node);

        Queue<Node> cqueue = new ArrayDeque<>();
        while (mqueue.size() > 0) {
            Node temp = mqueue.remove();
            System.out.print(temp.data + " ");
            // adding all children node in cqueue
            for (Node child : temp.childrenNode) {
                cqueue.add(child);
            }
            if (mqueue.size() == 0) {
                mqueue = cqueue;
                cqueue = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    // 3. ZigZack Line Wise Level Order Traversal
    public void zigzagLinewiseLevelOrderTraversal(Node node) {
        Stack<Node> mStack = new Stack<>();
        mStack.push(node); // adding root node

        Stack<Node> cStack = new Stack<>();
        int level = 0;
        while (mStack.size() > 0) {
            Node temp = mStack.pop();
            System.out.print(temp.data + " ");

            // adding all children node in cStack
            if (level % 2 == 0) {
                for (Node child : temp.childrenNode) {
                    cStack.push(child);
                }

                /*
                 OR
                 for(int i =0;i<temp.childrenNode.size();i++) {
                     Node childTemp = temp.childrenNode.get(i);
                     cStack.push(childTemp);
                 }
                 */
            } else {
                // adding all children node in cStack in reverse order
                for (int i = temp.childrenNode.size() - 1; i >= 0; i--) {
                    Node childTemp = temp.childrenNode.get(i);
                    cStack.push(childTemp);
                }
            }

            if (mStack.size() == 0) {
                mStack = cStack;
                cStack = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

}
