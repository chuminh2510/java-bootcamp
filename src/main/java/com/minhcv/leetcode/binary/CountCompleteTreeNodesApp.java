package com.minhcv.leetcode.binary;

import javax.swing.tree.TreeNode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteTreeNodesApp {

    public static void main(String[] args) {

    }

    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int count = 1;
            count += countNodes(root.left);
            count += countNodes(root.right);
            return count;
        }

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
