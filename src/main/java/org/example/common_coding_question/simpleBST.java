package org.example.common_coding_question;

public class simpleBST {
    public static class Node {
        int key;
        String data;
        Node left, right;

        public Node(int key, String value) {
            this.key = key;
            this.data = value;
        }
    }

    public Node root;

    public simpleBST() { root = null; }

    public void insert(int key, String data) {
        // walking from root node to insert once there's null
        root = insertNode(root, key, data);
    }

    private Node insertNode(Node node, int newKey, String newData) {
        Node newNode = new Node(newKey, newData);
        if (node == null) {
            node = newNode;
            return node;
        }

        // other than that, walk until we meet the null node and set it
        // smaller children will be on the left of parent node and opposite for larger
        if (newKey < node.key) {
            node.left = insertNode(node.left, newKey, newData);
        }
        else if (newKey > node.key) {
            node.right = insertNode(node.right, newKey, newData);
        }

        return node;
    }

    public void addNodeInOrder(Node node1, Node node2, String branch) {
        if (node1 != null) {
            switch (branch) {
                case "left" ->
                    node1.left = node2;
                case "right" ->
                    node1.right = node2;
            }
        }
    }

    // Get node order under String type
    public String getOrder() {
        StringBuilder sb = new StringBuilder();
        PreOrderTraversal(root, sb);
        return sb.toString();
    }

    private void PreOrderTraversal(Node node, StringBuilder sb) {
        // traversal means walking from left to right of the tree
        if (node != null) {
            if (sb != null) {
                sb.append(node.key);
            }
            PreOrderTraversal(node.left, sb);
            PreOrderTraversal(node.right, sb);
        }
    }

    public boolean isSubTree(simpleBST tree1, simpleBST tree2) {
        String order1 = tree1.getOrder();
        String order2 = tree2.getOrder();

        return order1.contains(order2);
    }

    // Algorithm to found sum of paths to a node
    public int countPathsWithSum(int targetSum){
        return countPathsWithSum(root, targetSum);
    }

    private int countPathsWithSum(Node root, int targetSum) {
        if (root == null) return 0;

        // count paths with sum starting from root
        int pathFromRoot = countPathsWithSumFromNode(root, targetSum, 0);

        // Try with Node from left and right
        int pathFromLeft = countPathsWithSum(root.left, targetSum);
        int pathFromRight = countPathsWithSum(root.right, targetSum);

        return pathFromRoot + pathFromLeft + pathFromRight;
    }

    private int countPathsWithSumFromNode(Node node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.key;
        int totalPaths = 0;
        if (currentSum == targetSum) { // Found a path from root
            totalPaths++;
        }

        totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
        return totalPaths;
    }

}
