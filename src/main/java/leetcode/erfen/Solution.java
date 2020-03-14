package leetcode.erfen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {

    /**
     * 二分查找
     *
     * @param nums
     */
    public int test(int nums[], int num) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (e + s) / 2;
            System.out.println("中间数  " + mid);
            if (num > nums[mid]) {
                s = mid + 1;
            } else if (num < nums[mid]) {
                e = mid - 1;
            } else {
                return mid;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int a[] = {2, 7, 10, 21, 168, 172, 200};
        Solution solution = new Solution();
        System.out.println("最终位置 " + solution.test(a, 9));
    }
}