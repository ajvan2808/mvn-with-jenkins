package org.example;

/**
 * binarySearchTree
 */
public class binarySearchTree {

    class Node {
        int key;
        String value; // can be any data structure
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }

        // method find min
        public Node min() {
            if (left == null) {
                return this; 
            }
            else {
                return left.min();
            }
        }
    }

    Node root;

    public binarySearchTree() {
        root = null;
    }

    // Calling find method
    public String find(int key) {
        // Start searching from root
        Node node = find(root, key);
        return node == null ? null: node.value;
    }

    // Implementation of Find method
    // We don't compare key == root.key cause duplicated keys are not allowed
    private Node find(Node node, int key) {
        if(node == null || node.key == key) {
            return node;
        }
        else if (key < node.key) {
            // using recursion
            return find(node.left, key);
        }
        else if(key > node.key) {
            return find(node.right, key);
        }
        else {
            return null;
        }
    }

    
    // insert
    public void insert(int key, String value) {
        // start walking from root
        root = insertItem(root, key, value);
    }

    // implementing insert item
    public Node insertItem(Node node, int keyToInsert, String valueToInsert) {
        Node newNode = new Node(keyToInsert, valueToInsert);

        // if current node is null, set it to new node
        if(node == null) {
            node = newNode;
            return node;
        }

        // other than that, walk until we meet the null node and set it
        if (keyToInsert < node.key) {
            node.left = insertItem(node.left, keyToInsert, valueToInsert);
        } 
        else {
            node.right = insertItem(node.right, keyToInsert, valueToInsert);
        }
        return node;
    }

    // findMin
    public Node findMin(Node node) {
        return node.min();
    }

    // delete
    public void delete(int key) {
        // start at root
        root = delete(root, key);
    }

    public Node delete(Node node, int key) {
        if (node == null) {
            return null;
        } 
        else if (key < node.key) {
            node.left = delete(node.left, key);
        }
        else if (key > node.key) {
            node.right = delete(node.right, key);
        }
        else {
            // till we've found the node to delete
            // Case 1: no child
            if (node.left == null && node.right == null) {
                node = null;
            }

            // Case 2: One child
            else if (node.left == null) {
                node = node.right;
            }
            else if (node.right == null) {
                node = node.right;
            }

            // Case 3: Two children
            else {
                // Find minimum node on the right (could be max on the left)
                Node minRight = findMin(node.right);

                // duplicate by copy the value
                node.key = minRight.key;
                node.value = minRight.value;

                // delete the node we just duplicated (same key)
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }
}