package leetcode.linkedlist;

/**
 */
public class Solution2 {

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode node = res;
        int temp = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + temp;
            if (val >= 10) {
                val = val - 10;
                temp = 1;
            } else {
                temp = 0;
            }
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode temp1 = null;
        if (l1 != null) {
            temp1 = l1;
        } else if (l2 != null) {
            temp1 = l2;
        }
        while (temp1 != null) {
            int val = temp1.val + temp;
            if (val >= 10) {
                val = val - 10;
                temp = 1;
            } else {
                temp = 0;
            }
            res.next = new ListNode(val);
            res = res.next;
            temp1 = temp1.next;
        }
        if(temp==1){
            res.next = new ListNode(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        //int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[] a = {5};
        int[] b = {5};
        System.out.println(solution.addTwoNumbers2(new ListNode(a),new ListNode(b)));
    }


}