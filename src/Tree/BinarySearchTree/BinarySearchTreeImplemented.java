package Tree.BinarySearchTree;

import Tree.BinaryTree.BinaryTreeImplemented;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

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


//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------Traversal---------------------------------------------------------------------------------------------------------------

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

    //Add A Node
    public Node add(Node node, int data) {
        if (node == null) {
            return new Node(data, null, null);
        }
        if (data < node.data) {
            //if data is less than node.data than go to left child node tell him to
            // add the data and in return attach the left node result with Parent node.left
            Node leftNode = add(node.left, data);
            // when any node addition is takes place then all attached nodes go disturb so reattach the node with the parent node
            node.left = leftNode;
            return node;
        } else if (data > node.data) {
            Node rightNode = add(node.right, data);
            node.right = rightNode;
            return node;
        } else {
            return node;
        }
    }

    //Removing A Node
    public Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            Node removeLeft = remove(node.left, data);
            node.left = removeLeft;
            return node;
        } else if (data > node.data) {
            Node removeRight = remove(node.right, data);
            node.right = removeRight;
            return node;
        }
        // node.data == data
        else {
            // when node has no child node
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                // when it has right child
                return node.right;
            } else if (node.right == null) {
                //w when it has left child only
                return node.left;
            } else {
                // when it has all two child

                // find the max node in left child
                int maxLeft = max(node.left);

                //then remove that max node
                Node removesMax = remove(node.left, maxLeft);

                // then add it in place of node that is to be deleted
                node.data = removesMax.data; // Or node.data = maxLeft
                node.left = removesMax;
                return node;
            }
        }
    }

    //Print in descending Order (It will be done will the help of Reverse In-order traversal)
    public void printNodeInDescendingOrder(Node node) {
        if (node == null) {
            return;
        }
        printNodeInDescendingOrder(node.right);

        System.out.print(node.data + " ");

        printNodeInDescendingOrder(node.left);
    }

    //Print in ascending Order (It will be done will the help of just simple In-order traversal)
    public void printNodeInAscendingOrder(Node node) {
        if (node == null) {
            return;
        }
        printNodeInAscendingOrder(node.left);

        System.out.print(node.data + " ");

        printNodeInAscendingOrder(node.right);
    }


    //Replace the node with sum of the node which is greater than that node if not then with replace with 0
    int sum = 0;

    public void replaceNodesWithSumOfNodes(Node node) {
        if (node == null) {
            return;
        }
        replaceNodesWithSumOfNodes(node.right);

        //replacing node data with sum of nodes with is greater than that node
        int nodeData = node.data;
        node.data = sum;
        sum += nodeData;

        replaceNodesWithSumOfNodes(node.left);
    }


    //Lowest Common Ancestor
    public int lca(Node node, int num1, int num2) {
        if (num1 < node.data && num2 < node.data) {
            //move to left side
            return lca(node.left, num1, num2);
        } else if (num1 > node.data && num2 > node.data) {
            // move to right side
            return lca(node.right, num1, num2);
        } else {
            //this is the condition when it will find the lca
            return node.data;
        }
    }

    //Print all the node with comes in range low-high
    public void printAllNodeInRange(Node node, int low, int high) {
        if (node == null) {
            return;
        }
        if (low < node.data && high < node.data) {
            printAllNodeInRange(node.left, low, high);
        } else if (low > node.data && high > node.data) {
            printAllNodeInRange(node.right, low, high);
        } else {
            printAllNodeInRange(node.left, low, high);
            System.out.print(node.data + " ");
            printAllNodeInRange(node.right, low, high);
        }
    }

    // Or use In-Order if you want to print it in ascending order
    public void printAllNodeInRange2(Node node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.data >= low && node.data <= high) {
            System.out.print(node.data + " ");
        }
        printAllNodeInRange2(node.left, low, high);
        /*
        Do this if you want to print it in ascending order and remove upper if if-condition
          if (node.data >=low && node.data <= high) {
            System.out.print(node.data +" ");
        }
         */
        printAllNodeInRange2(node.right, low, high);
    }


    //Print The Pair who's Sum Is Equals To Target and print lowest part of in ascending order.

    //Method 1
    public void printThePairWhosSumIsEqualsToTarget(Node root, Node node, int target) {
        if (node == null) {
            return;
        }
        // we have print the lowest in ascending order so we will be using in-Order
        printThePairWhosSumIsEqualsToTarget(root, node.left, target);

        int numberToSearch = target - node.data;
        // ex:- target =100 ,node.data= 30 so that numberToSearch = 100 - 30 = 70
        // and now search that term in tree if it exists then  print the "node.data- numberToSearch"

        if (numberToSearch > node.data) /* this condition is for avoiding situation like 30-70 and 70-30; */ {
            if (find(root, numberToSearch)) {
                System.out.println(node.data + "-" + numberToSearch);
            }
        }
        printThePairWhosSumIsEqualsToTarget(root, node.right, target);
    }

    //Method 2 By ArrayListMethod

    public void printThePairWhosSumIsEqualsToTarget2(Node node, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        helperPrintThePairWhosSumIsEqualsToTarget2(node, list);

        int i = 0, j = list.size() - 1;
        while (i < j) {
            int left = list.get(i);
            int right = list.get(j);
            if (left + right < target) {
                //if this condition is true then do i++ to search for greater value
                // for addition with j so that it become equal to target
                i++;
            } else if (left + right > target) {
                //if this condition is true then do j++ to search for smaller value
                // for addition with i so that it become equal to target
                j--;
            } else {
                // if left + right == target
                System.out.println(left + "-" + right);
                i++;
                j--;
            }
        }
    }

    private void helperPrintThePairWhosSumIsEqualsToTarget2(Node node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        helperPrintThePairWhosSumIsEqualsToTarget2(node.left, list);
        list.add(node.data);
        helperPrintThePairWhosSumIsEqualsToTarget2(node.right, list);
    }

    //Method 3 By Iterative In-Order and Reverse Iterative In-Order

    private class PrintThePair {
        Node node;
        int state = 0;

        public PrintThePair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public void printThePairWhosSumIsEqualsToTargetBestApproach(Node node, int target) {
        Stack<PrintThePair> leftStack = new Stack<>();
        Stack<PrintThePair> rightStack = new Stack<>();

        leftStack.push(new PrintThePair(node, 0));
        rightStack.push(new PrintThePair(node, 0));

        Node left = getNextFromNormalInOrder(leftStack);
        Node right = getNextFromReverseInOrder(rightStack);

        while (left.data < right.data) {
            if (left.data + right.data < target) {
                left = getNextFromNormalInOrder(leftStack);
            } else if (left.data + right.data < target) {
                right = getNextFromReverseInOrder(rightStack);
            } else {
                System.out.println(left.data + "-" + right.data);
                left = getNextFromNormalInOrder(leftStack);
                right = getNextFromReverseInOrder(rightStack);
            }
        }

    }

    private Node getNextFromNormalInOrder(Stack<PrintThePair> st) {
        while (st.size() > 0) {
            PrintThePair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new PrintThePair(top.node.left, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new PrintThePair(top.node.right, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        return null;
    }

    private Node getNextFromReverseInOrder(Stack<PrintThePair> st) {
        while (st.size() > 0) {
            PrintThePair top = st.peek();
            if (top.state == 0) {
                if (top.node.right != null) {
                    st.push(new PrintThePair(top.node.right, 0));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.left != null) {
                    st.push(new PrintThePair(top.node.left, 0));
                }
                top.state++;
                return top.node;
            } else {
                st.pop();
            }
        }
        return null;
    }
}
