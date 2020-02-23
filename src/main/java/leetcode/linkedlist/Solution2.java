package leetcode.linkedlist;

/**
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1, size2;
        //计算出两个列表的数
        ListNode temp;
        temp = l1;
        size1 = 0;
        while (temp != null) {
            size1++;
            temp = temp.next;
        }
        temp = l2;
        size2 = 0;
        while (temp != null) {
            size2++;
            temp = temp.next;
        }
        ListNode res = new ListNode(0);
        temp = res;
        //头指针
        ListNode temp1, temp2;
        int preSize;
        if (size1 > size2) {
            preSize = size1 - size2 - 1;
            while (preSize-- > 0 && l1 != null) {
                temp.next = new ListNode(l1.val);
                temp = temp.next;
                l1 = l1.next;
            }
            temp1 = l1;
            temp2 = new ListNode(0);
            temp2.next = l2;
        } else if (size2 > size1) {
            preSize = size2 - size1;
        }

        while (l1 != null && l2 != null) {

        }


        return res.next;
    }

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