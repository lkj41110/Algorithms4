//package leetcode.linkedlist;
//
//
//import org.omg.PortableServer.LIFESPAN_POLICY_ID;
//
//public class Solution445 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int len1 = 0;
//        ListNode temp = l1;
//        while (temp != null) {
//            len1++;
//            temp = temp.next;
//        }
//
//        int len2 = 0;
//        temp = l2;
//        while (temp != null) {
//            len2++;
//            temp = temp.next;
//        }
//
//        ListNode s;
//        ListNode b;
//        int i;
//        if (len1 > len2) {
//            b = l1;
//            s = l2;
//            i = len1 - len2;
//        } else {
//            b = l2;
//            s = l1;
//            i = len1 - len2;
//        }
//        ListNode root = new ListNode();
//        ListNode bT = b;
//        ListNode sT = s;
//        temp = root;
//        while (i-- > 0) {
//            ListNode newNode = new ListNode();
//            newNode.val = bT.val;
//
//        }
//    }
//
//    private ListNode p(ListNode root) {
//        if (root == null) {
//            return null;
//        }
//        ListNode temp = root;
//        ListNode next = root.next;
//        while (next != null) {
//            ListNode next2 = next.next;
//            next.next = temp;
//            temp.next = null;
//            temp = next;
//            next = next2;
//        }
//        return temp;
//    }
//
//    public static void main(String[] args) {
//        Solution445 solution = new Solution445();
//        int[] a = {1, 2, 3, 4};
//        solution.reorderList(new ListNode(a));
//    }
//
//
//}