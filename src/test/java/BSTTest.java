//package src.test.java;

import org.junit.Assert;
import org.junit.Test;
import org.example.common_coding_question.simpleBST;

public class BSTTest {

    @Test
    public void testSubTree() {
        // Given 2 BST: write algorithm to check whether a tree is subtree of another or not
        simpleBST testTree1 = new simpleBST();
        simpleBST testTree2 = new simpleBST();

        testTree1.insert(1, "one");
        testTree1.insert(2, "two");
        testTree1.insert(3, "three");
        testTree1.insert(4, "four");
        testTree1.insert(5, "five");
        testTree1.insert(6, "six");

        testTree2.insert(4, "four");
        testTree2.insert(5, "five");
        testTree2.insert(6, "six");

        Assert.assertTrue(testTree1.isSubTree(testTree1, testTree2));
        Assert.assertEquals("456", testTree2.getOrder());
    }

    @Test
    public void testPathWithSum() {
        // Challenge: Given a binary tree that contains positive and negative keys
        // Design an algorithm to find the number of path in tree that sum to the given value

        simpleBST binaryTree = new simpleBST();
        binaryTree.insert(10, "one"); // root

        simpleBST.Node node1 = new simpleBST.Node(5, "");
        simpleBST.Node node2 = new simpleBST.Node(-3, "");
        simpleBST.Node node3 = new simpleBST.Node(3, "");
        simpleBST.Node node4 = new simpleBST.Node(2, "");
        simpleBST.Node node5 = new simpleBST.Node(11, "");
        simpleBST.Node node6 = new simpleBST.Node(3, "");
        simpleBST.Node node7 = new simpleBST.Node(-2, "");
        simpleBST.Node node8 = new simpleBST.Node(1, "");

        binaryTree.addNodeInOrder(binaryTree.root, node1, "left");
        binaryTree.addNodeInOrder(binaryTree.root, node2, "right");
        binaryTree.addNodeInOrder(node1, node3, "left");
        binaryTree.addNodeInOrder(node1, node4, "right");
        binaryTree.addNodeInOrder(node2, node5, "right");
        binaryTree.addNodeInOrder(node3, node6, "left");
        binaryTree.addNodeInOrder(node3, node7, "right");
        binaryTree.addNodeInOrder(node4, node8, "right");

        Assert.assertEquals(3, binaryTree.countPathsWithSum(8));
    }
}
