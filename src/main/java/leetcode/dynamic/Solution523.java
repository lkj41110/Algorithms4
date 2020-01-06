package leetcode.dynamic;

/**
 * 动态规划
 * 优化点：一个数组
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return false;
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        if (k == 0)
            return false;
        int[] sums = new int[len];
        sums[0] = nums[0];
        sums[1] = sums[0] + nums[1];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int sum;
                sums[i] = sums[i - 1] + nums[i];
                sum = sums[i] - sums[i - 2];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum1(int[] nums, int k) {
        //if (k == 0)
        //    return false;
        int len = nums.length;
        if (len < 2) return false;
        for (int i = 0; i < nums.length - 1; ++i)
            if (nums[i] == 0 && nums[i + 1] == 0) return true;
        if (k == 0)
            return false;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = nums[i] % k;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int sum = res[j][i - 1] + nums[i];
                if (sum % k == 0) {
                    return true;
                } else {
                    res[j][i] = sum;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution523 solution = new Solution523();
        //int[] a = {1, 2, 12};
        //System.out.println(solution.checkSubarraySum(a, 6));
        int[] b = {1, 1};
        System.out.println(solution.checkSubarraySum(b, -1));
    }


}