package leetcode.erfen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * <p>
 * 翻转求最小值 有重复值
 * }
 */
class Solution5 {
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        if (nums[s] < nums[e]) {
            return nums[s];
        }
        while (nums[s] >= nums[e]) {
            int mid = e + (s - e) / 2;
            if (e - s == 1) {
                s = e;
                break;
            }
            if(nums[mid] == nums[e] && nums[mid] == nums[s]){
                int res = nums[e];
                for(int i = s + 1; i <= e; i++){
                    if(res > nums[i]){
                        res = nums[i];
                    }
                }
                return res;
            }
            if(nums[mid] >= nums[s]) s = mid;
            if(nums[mid] <= nums[e]) e = mid;
        }


        return nums[s];
    }


    public int find1(int[] nums, int s, int e) {
        if (s == e) {
            return nums[s];
        }
        int min = nums[s];
        while (s <= e) {
            int mid = (s + e) / 2;

            if (nums[mid] > nums[s]) { //前半段 ok
                min = Math.min(min, nums[s]);
                return e >= mid + 1 ? Math.min(min, find(nums, mid + 1, e)) : min;
            } else if (nums[mid] < nums[e]) { //后半段有序
                min = Math.min(min, nums[mid]);
                return mid - 1 >= s ? Math.min(min, find(nums, s, mid - 1)) : min;
            } else {
                if (e >= mid + 1) {
                    min = Math.min(find(nums, mid + 1, e), min);
                }
                if (mid - 1 >= s) {
                    min = Math.min(find(nums, s, mid - 1), min);
                }
                return min;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int a[] = {2,2,2,0,1};
        Solution5 solution = new Solution5();
        System.out.println(solution.findMin(a));
    }
}