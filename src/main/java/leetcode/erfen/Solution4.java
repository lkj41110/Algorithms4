package leetcode.erfen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 *
 * 翻转求最小值
 * }
 */
class Solution4 {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int s, int e) {
        if(s==e){
            return nums[s];
        }
        int min = nums[s];
        while (s <= e) {
            int mid = (s + e) / 2;

            if (nums[mid] >= nums[s]) { //前半段 ok
                min = Math.min(min, nums[s]);
                return Math.min(min, find(nums, mid + 1, e));
            }else {
                min = Math.min(min, nums[mid]);
                return Math.min(min, find(nums, s, mid - 1));
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int a[] = {2,1};
        Solution4 solution = new Solution4();
        System.out.println(solution.findMin(a));
    }
}