package leetcode.linkedlist;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);
        boolean flag = true;
        ListNode temp = head;
        ListNode temp1, temp2;
        temp1 = listNode1;
        temp2 = listNode2;
        while (temp != null) {
            if (flag) {
                temp1.next = temp;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
            flag = !flag;
        }
        temp1.next = null;
        temp2.next = null;
        listNode2 = p(listNode2.next);


        ListNode res = new ListNode(0);
        temp1 = listNode1.next;
        temp2 = listNode2;
        temp = res;
        flag = true;
        while (temp1 != null || temp2 != null) {
            if (flag) {
                temp.next = temp1;
                temp = temp.next;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp.next;
                temp2 = temp2.next;
            }
            flag = !flag;
        }
        head = res.next;
    }

    private ListNode p(ListNode root){
        if(root==null){
            return null;
        }
        ListNode temp = root;
        ListNode next = root.next;
        while (next!=null){
            ListNode next2 = next.next;
            next.next = temp;
            temp.next = null;
            temp = next;
            next = next2;
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution143 solution = new Solution143();
        int[] a = {1,2,3,4};
        solution.reorderList(new ListNode(a));
    }


}