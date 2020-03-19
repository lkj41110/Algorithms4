package leetcode.erfen;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private int dfs(int[] nums, int s, int e) {
        if (s > e) {
            return -1;
        }
        if (s == e) {
            return s;
        }
        int mid = s + (e - s) / 2;
        if (mid == s) {
            if (nums[mid] >= nums[mid + 1]) {
                return mid;
            }
            return dfs(nums, mid + 1, e);
        }
        if (mid == e) {
            if (nums[mid] >= nums[mid - 1]) {
                return mid;
            }
            return dfs(nums, s, mid - 1);
        }
        if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]) return mid;
        if (nums[mid] < nums[mid - 1]) {
            return dfs(nums, s, mid - 1);
        } else {
            return dfs(nums, mid + 1, e);
        }
    }

    public int findPeakElement2(int[] nums) {

        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[l]>=nums[mid]){
                r = mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int a[] = {1, 2};
        Solution162 solution = new Solution162();
        System.out.println("最终位置 " + solution.findPeakElement(a));
    }
}