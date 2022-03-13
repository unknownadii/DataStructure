package Tree.GenricTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenricTreeImplemented {
    public GenricTreeImplemented() {
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

    //Size of tree
    public int size(Node node) {
        int count = 0;
        for (Node child : node.childrenNode) {
            count += size(child);
        }
        count += 1;
        return count;
    }

    //Max value of tree
    public int maxValue(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.childrenNode) {
            max = Math.max(max, maxValue(child));
        }
        max = Math.max(max, node.data);
        return max;
    }

    //Min value of tree
    public int minValue(Node node) {
        int min = Integer.MAX_VALUE;
        for (Node child : node.childrenNode) {
            min = Math.min(min, maxValue(child));
        }
        min = Math.min(min, node.data);
        return min;
    }

    // Height Of the Tree
    public int heightInEdges(Node node) {
        int height = -1; //Take -1 when Edges height is asked
        for (Node child : node.childrenNode) {
            height = Math.max(height, heightInEdges(child));
        }
        height += 1;
        return height;
    }

    public int heightInNodes(Node node) {
        int height = 0; //Take 0 when Node Height is asked
        for (Node child : node.childrenNode) {
            height = Math.max(height, heightInNodes(child));
        }
        height += 1;
        return height;
    }

    //Find a element in tree
    public boolean find(Node node, int value) {
        if (node.data == value) {
            return true;
        }
        boolean temp = false;
        for (Node child : node.childrenNode) {
            temp = find(child, value);
        }
        return temp;
    }

    public Node findNode(Node node, int value) {
        if (node.data == value) {
            return node;
        }
        Node temp = null;
        for (Node child : node.childrenNode) {
            temp = findNode(child, value);
        }
        return temp;
    }

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


    // 4. Delimiter Approach Level Order Traversal
    public void delimiterMethodLinewiseLevelOrderTraversal(Node node) {
        Queue<Node> mQueue = new ArrayDeque<>();
        mQueue.add(node);
        mQueue.add(new Node(-1));

        while (mQueue.size() > 0) {
            Node temp = mQueue.remove();
            if (temp.data != -1) {
                System.out.print(temp.data + " ");

                for (Node child : temp.childrenNode) {
                    mQueue.add(child);
                }
            } else {
                if (mQueue.size() > 0) {
                    mQueue.add(new Node(-1));
                    System.out.println();
                }
            }
        }
    }

}
