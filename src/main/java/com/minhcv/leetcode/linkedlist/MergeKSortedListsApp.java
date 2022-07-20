package com.minhcv.leetcode.linkedlist;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedListsApp {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode node3 = new ListNode(2, new ListNode(6, null));
        ListNode[] lists = {node1, node2, node3};
        ListNode ret = new Solution().mergeKLists(lists);
        System.out.println("End!");
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
            for (ListNode node : lists) {
                if (node == null) {
                    continue;
                }
                do {
                    pQueue.add(node.val);
                    node = node.next;
                } while (node != null);
            }
            ListNode head;
            ListNode newNode = new ListNode();
            head = newNode;
            while (pQueue.size() != 0) {
                newNode.next = new ListNode(pQueue.poll(), null);
                newNode = newNode.next;
            }
            return head.next;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
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
