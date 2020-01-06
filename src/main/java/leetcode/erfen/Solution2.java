package leetcode.erfen;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        return search2(nums, target, 0, nums.length - 1);
    }

    public int[] search2(int[] nums, int target, int s, int e) {
        int[] res = {-1, -1};
        if (s > e) return res;
        if (s == e) {
            if (nums[s] == target) {
                res[0] = res[1] = s;

            }
            return res;
        }
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) {
                int[] res1 = search2(nums, target, s, mid);
                int[] res2 = search2(nums, target, mid + 1, e);
                if(res2[0]>=res1[1]) {
                    res[0] = res1[0];
                    res[1] = res2[1];
                    return res;
                }else{
                    return res1;
                }
            } else if (nums[mid] > target) {
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int a[] = {5, 7, 7, 8, 8, 10};
        Solution2 solution = new Solution2();
        System.out.println(solution.searchRange(a, 6)[0] + " , " + solution.searchRange(a, 6)[1]);
    }
}