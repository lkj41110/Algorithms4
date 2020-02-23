package leetcode.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] list) {
        val = list[0];
        ListNode temp = this;
        for (int i = 1; i < list.length; i++) {
            temp.next = new ListNode(list[i]);
            temp = next;
        }
    }
}