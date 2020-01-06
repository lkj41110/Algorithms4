package leetcode.erfen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean search(int[] nums, int target) {

        int s = 0, e = nums.length - 1;
        return search1(nums, target, s, e);
    }
    public boolean search1(int[] nums, int target, int s, int e) {
        if(s==e){
            if(nums[s]==target)
                return true;
            else
                return false;
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                return mid>=0;
            }

            if (nums[s] < nums[mid]) {
                //表示前半段有序
                if (target <= nums[mid] && target >= nums[s]) {
                    return search2(nums, target, s, mid);
                }
                s = mid + 1;
            } else if(nums[mid]<nums[e]){
                //表示后半段有序
                if (target >= nums[mid] && target <= nums[e]) {
                    return search2(nums, target, mid, e);
                }
                e = mid - 1;
            }else{
                boolean res1 = search1(nums, target, s, mid - 1);
                boolean res2 = search1(nums, target, mid+1, e);
                return res1 || res2;
            }

        }
        return false;
    }

    public boolean search2(int[] nums, int target, int s, int e) {
        if (target < nums[s] || target > nums[e]) {
            return false;
        }
        int t_s = s;
        int t_e = e;
        while (t_s <= t_e) {
            int mid = (t_e + t_s) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                t_e = mid - 1;
            } else {
                t_s = mid + 1;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int a[] = {1,1,1,1,3,1,1,1,1,1,1,1,1};
        Solution solution = new Solution();
        System.out.println(solution.search(a, 3));
    }
}