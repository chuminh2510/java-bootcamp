package com.minhcv.leetcode.recursion;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairApp {
    static class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode node = swapTwoAdjacentNodes(head);
            return node;
        }

        public ListNode swapTwoAdjacentNodes(ListNode node) {
            if (node == null) {
                return null;
            }
            ListNode next = node.next;
            if (node.next == null) {
                return node;
            }
            ListNode outputNode = swapTwoAdjacentNodes(next.next);
            next.next = node;
            node.next = outputNode;
            return next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
