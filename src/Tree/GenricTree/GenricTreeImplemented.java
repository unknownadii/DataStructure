package Tree.GenricTree;

import java.util.*;

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


/*
========================================================================================================================
========================================================================================================================
                                                     Questions
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

    // 5. Count Approach Level Order Traversal
    public void countLevelOrderTraversal(Node node) {
        Queue<Node> mQueue = new ArrayDeque<>();
        //adding the root
        mQueue.add(node);
        while (mQueue.size() > 0) {
            int count = mQueue.size();
            for (int i = 0; i < count; i++) {
                node = mQueue.remove();
                System.out.print(node.data + " ");
                for (Node child : node.childrenNode) {
                    mQueue.add(child);
                }
            }
            System.out.println();
        }
    }

    // 6. Pair Class With Level Approach Level Order Traversal
    public void pairClassWithLevelMethodLinewiseLevelOrderTraversal(Node node) {
        Queue<Pair> mQueue = new ArrayDeque<>();
        mQueue.add(new Pair(node, 1));
        int level = 1;
        while (mQueue.size() > 0) {
            Pair p = mQueue.remove();
            if (p.level > level) {
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for (Node child : p.node.childrenNode) {
                Pair childPair = new Pair(child, p.level + 1);
                mQueue.add(childPair);
            }
        }
    }

    private class Pair {
        Node node;
        int level;

        public Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /*
    -----------------------------------------Questions------------------------------------------------------------------
     */

    //Question :- Convert tree in to mirror Tree
    public void mirrorOfTree(Node node) {
        for (Node child : node.childrenNode) {
            mirrorOfTree(child);
        }
        //childrenNode is ArrayList so we are able to apply directly reverse function on this whole List
        Collections.reverse(node.childrenNode);
    }

    // Question remove all leaf node from tree
    public void removeLeafs(Node node) {
        // checking the all it's Own children node that it is leaf or not
        for (int i = node.childrenNode.size() - 1; i >= 0; i--) {
            Node child = node.childrenNode.get(i);
            //checking that the node has any childrean node or not   if it has any node childrean then it is not leaf node
            if (child.childrenNode.size() == 0) {
                node.childrenNode.remove(i);
            }
        }

        // Now asking all remaining children nodes to remove it's own leaf node
        for (Node child : node.childrenNode) {
            removeLeafs(child);
        }
    }


    //Question :- Linearize A Tree
    public void linearizeOfGenricTree(Node node) {
        for (Node child : node.childrenNode) {
            linearizeOfGenricTree(child);
        }
        for (int i = node.childrenNode.size() - 2; i >= 0; i--) {
            Node lastChild = node.childrenNode.remove(i + 1);
            // getting the tail node of second last children
            Node secondLast = getTail(node.childrenNode.get(i));
            //adding last children node into the second last tail node.
            secondLast.childrenNode.add(lastChild);
        }
    }

    private Node getTail(Node node) {
        while (node.childrenNode.size() >= 1) {
            int indexLast = node.childrenNode.size() - 1;
            node = node.childrenNode.get(indexLast);
        }
        return node;
    }

    public Node linearizeOfGenricTreeMethod2(Node node) {
        if (node.childrenNode.size() == 0) {
            return node;
        }
        Node lastChildNode = linearizeOfGenricTreeMethod2(node.childrenNode.get(node.childrenNode.size() - 1));
        while (node.childrenNode.size() > 1) {
            Node lastNode = node.childrenNode.remove(node.childrenNode.size() - 1);
            // after removing a node the size will decrease by one and the second last node will become last node
            Node secondLastNode = node.childrenNode.get(node.childrenNode.size() - 1);
            Node lastTailNode = linearizeOfGenricTreeMethod2(secondLastNode);
            lastTailNode.childrenNode.add(lastNode);
        }
        return lastChildNode;
    }


    //Question :- Node To Root Path
    public ArrayList<Integer> node2RootPath(Node node, int nodeToFindData) {
        if (node.data == nodeToFindData) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for (Node child : node.childrenNode) {
            ArrayList<Integer> returnedList = node2RootPath(child, nodeToFindData);
            if (returnedList.size() > 0) {
                returnedList.add(node.data);
                return returnedList;
            }
        }
        return new ArrayList<>();
    }


    //Question :- Lowest comman anciester
    public int lca(Node node, int firstNode, int secondNode) {

        // find first node to root path then find first matching value in list and returned it.
        ArrayList<Integer> fNode = node2RootPath(node, firstNode);
        ArrayList<Integer> sNode = node2RootPath(node, secondNode);
        int i = fNode.size() - 1, j = sNode.size() - 1;
        while (i >= 0 && j >= 0 && fNode.get(i) == sNode.get(j)) {
            i--;
            j--;
        }
        return fNode.get(i + 1); // OR  return sNode.get(i+1);
    }


    //Question :- Distance between two nodes
    public int distanceBetweenTwoNodes(Node node, int firstNode, int secondNode) {

        // find first node to root path then find first matching value in list and returned it.
        ArrayList<Integer> fNode = node2RootPath(node, firstNode);
        ArrayList<Integer> sNode = node2RootPath(node, secondNode);
        int i = fNode.size() - 1, j = sNode.size() - 1;
        while (i >= 0 && j >= 0 && fNode.get(i) == sNode.get(j)) {
            i--;
            j--;
        }
        return (i + 1) + (j + 1);
    }


    //Question :- Are trees Similar in Shape
    public boolean areTreeSimilar(Node n1, Node n2) {
        if (n1.childrenNode.size() != n2.childrenNode.size()) {
            return false;
        }
        for (int i = 0; i < n1.childrenNode.size(); i++) {
            Node f = n1.childrenNode.get(i);
            Node s = n2.childrenNode.get(i);
            if (areTreeSimilar(f, s) == false) {
                return false;
            }
        }
        return true;
    }
}
