package Tree;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.Stack;

public class GenricTree {
    private static class Node {
        int data;
        ArrayList<Node> childrenNode = new ArrayList<>();
    }

    public static void main(String[] args) {
        int arr[] = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 100, -1, 120, -1, -1, 90, -1, 40, 100, -1, -1, -1};
        Node root = contructGenricTree(arr);

        System.out.println(size(root));

        display(root);

        System.out.println(maxValue(root));
        System.out.println(minValue(root));

        System.out.println(heightInEdges(root));
        System.out.println(heightInNodes(root));

        System.out.println(find(root, 1080));
        Node temp = findNode(root, 100);
        if (temp != null) {
            System.out.println("Found -> " + temp.data);
        } else {
            System.out.println("Not Found");
        }


    }

    static Node contructGenricTree(int arr[]) {
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

    static void display(Node node) {
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
    static int size(Node node) {
        int count = 0;
        for (Node child : node.childrenNode) {
            count += size(child);
        }
        count += 1;
        return count;
    }

    //Max value of tree
    static int maxValue(Node node) {
        int max = Integer.MIN_VALUE;
        for (Node child : node.childrenNode) {
            max = Math.max(max, maxValue(child));
        }
        max = Math.max(max, node.data);
        return max;
    }

    //Min value of tree
    static int minValue(Node node) {
        int min = Integer.MAX_VALUE;
        for (Node child : node.childrenNode) {
            min = Math.min(min, maxValue(child));
        }
        min = Math.min(min, node.data);
        return min;
    }

    // Height Of the Tree
    static int heightInEdges(Node node) {
        int height = -1; //Take -1 when Edges height is asked
        for (Node child : node.childrenNode) {
            height = Math.max(height, heightInEdges(child));
        }
        height += 1;
        return height;
    }

    static int heightInNodes(Node node) {
        int height = 0; //Take 0 when Node Height is asked
        for (Node child : node.childrenNode) {
            height = Math.max(height, heightInNodes(child));
        }
        height += 1;
        return height;
    }

    //Find a element in tree
    static boolean find(Node node, int value) {
        if (node.data == value) {
            return true;
        }
        boolean temp = false;
        for (Node child : node.childrenNode) {
            temp = find(child, value);
        }
        return temp;
    }

    static Node findNode(Node node, int value) {
        if (node.data == value) {
            return node;
        }
        Node temp = null;
        for (Node child : node.childrenNode) {
            temp = findNode(child, value);
        }
        return temp;
    }

}
