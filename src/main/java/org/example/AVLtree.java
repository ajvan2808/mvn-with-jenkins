package org.example;

class Node {
    int key, height;
    Node left, right;

    public Node(int d) {
        key = d;
        height = 1;
    }
}

/**
 * AVLtree
 */
public class AVLtree {

    public Node root;

    // Utility func to get the height of tree
    public int height(Node N) {
        if (N == null) {
            return 0;
        }
        return N.height;
    }

    // Utility func to get max out of two integers
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotate sub tree rooted with y
    Node rightRotateNode(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        System.out.println("Before rotation:");
        System.out.println("y = " + y.key);
        System.out.println("x = " + x.key);
        if(T2 == null) {
            System.out.println("T2 == null");
        }
        else {
            System.out.println("T2 = " + T2.key);
        }

        // PERFORM ROTATION
        x.right = y;
        y.left = T2;

        // Update height
        y.height = max(height(y.left), height(y.right) + 1);
        x.height = max(height(x.left), height(x.right) + 1);

        // Return new root
        return x;
    }

    // Left rotate sub tree rooted with x
    Node leftRotatNode(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update height
        x.height = max(height(x.left), height(x.right) + 1);
        y.height = max(height(y.left), height(y.right) + 1);

        return y;
    }

    // GET BALANCE FACTOR OF NODE N
    int getBalance(Node N) {
        if (N == null) {
            return 0;
        }
        return height(N.left) - height(N.right);
    }

    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {

        // *1 Perform BST insertion
        if (node == null) {
            return new Node(key);
        }
        if (node.key > key) {
            node.left = insert(node.left, key);
        }
        else if(node.key < key) {
            node.right = insert(node.right, key);
        }
        else {
            // Duplicate nodes not allowed
            return node;
        }

        // *2 Update height of ancestor nodes
        node.height = max(height(node.left), height(node.right)) + 1;

        // *3 Check balance of ancestor node whether it becomes unbalanced or not
        int balance = getBalance(node);

        // If node become unbalanced, then there're 4 cases
        // (Left Left Case)
        if(balance > 1 && key < node.left.key) {
            System.out.println("Rotate right.");
            return rightRotateNode(node);
        }

        // Right Right case
        if (balance < -1 && key > node.right.key) {
            System.out.println("Rotate left.");
            return leftRotatNode(node);
        }

        // Left Right case
        if (balance > 1 && key > node.left.key) {
            System.out.println("Rotate left then right");
            node.left = leftRotatNode(node.left);
            return rightRotateNode(node);
        }

        // Right Left case
        if (balance < -1 && key < node.right.key) {
            System.out.println("Rotate right then left");
            node.right = rightRotateNode(node.right);
            return leftRotatNode(node);
        }

        return node;

    }

    // A utility function to print preorder traversal of
    // the tree. The function also prints height of every
    // node
    public void preOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

}
