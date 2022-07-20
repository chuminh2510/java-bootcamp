package com.minhcv.leetcode.binary;

/**
 * InorderSuccessorApp
 */
public class InorderSuccessorApp {

    public static void main(String[] args) {
        System.out.println("Test");
    }

    Node root;

    Node findInorderSuccessor(Node inputNode) {

        return null;
    }

    Node search(Node inputNode, Node currentNode) {
        if (inputNode.val == currentNode.val) {
            if (currentNode.right != null) {
                return findMinNode(currentNode.right);
            } else {
                return inputNode;
            }
        } else if (inputNode.val < currentNode.val) {
            Node retNode = search(inputNode, currentNode.left);
            if (retNode.val == inputNode.val) {
                return currentNode;
            }
        } else {
            Node retNode = search(inputNode, currentNode.right);

        }

        return null;

    }

    Node findMinNode(Node node) {
        if (node.left != null) {
            return findMinNode(node.left);
        } else {
            return node;
        }
    }

    /**
     * Node
     */

    public class Node {
        int val;
        Node left;
        Node right;
    }
}