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
}
