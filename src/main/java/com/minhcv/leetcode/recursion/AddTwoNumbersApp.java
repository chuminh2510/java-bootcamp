package com.minhcv.leetcode.recursion;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbersApp {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        Solution sol = new Solution();
        sol.addTwoNumbers(l1, l2);
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            return appendVal(l1, l2, 0);
        }

        public ListNode appendVal(ListNode l1, ListNode l2, int buff) {
            int sum = 0;
            if (l1 == null && l2 == null) {
                if (buff > 0) {
                    sum = buff;
                    return new ListNode(sum, null);
                }
                return null;
            } else if (l1 == null) {
                sum = l2.val + buff;
                buff = 0;
                if (sum >= 10) {
                    sum -= 10;
                    buff = 1;
                }
                return new ListNode(sum, appendVal(null, l2.next, buff));
            } else if (l2 == null) {
                sum = l1.val + buff;
                buff = 0;
                if (sum >= 10) {
                    sum -= 10;
                    buff = 1;
                }
                return new ListNode(sum, appendVal(l1.next, null, buff));
            } else {
                sum = l1.val + l2.val + buff;
                buff = 0;
                if (sum >= 10) {
                    sum -= 10;
                    buff = 1;
                }
                return new ListNode(sum, appendVal(l1.next, l2.next, buff));
            }
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
