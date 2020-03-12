package leetcode.other;

import leetcode.linkedlist.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution1013 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        int len1 = 0;
        while (temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        ListNode temp2 = headB;
        int len2 = 0;
        while (temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }
        temp1 = headA;
        temp2 = headB;
        int temp;
        if (len1 > len2) {
            temp = len1 - len2;
            while (temp-- > 0) {
                temp1 = temp1.next;
            }
        } else {
            temp = len2 - len1;
            while (temp-- > 0) {
                temp2 = temp2.next;
            }
        }


        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}