package leetcode.tanxin;


import java.util.HashSet;
import java.util.Set;

/**
 * 简单的贪心算法
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 2
 * 输出：2
 * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
 * 示例 2：
 */
class Solution1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int res = 0;
        set.add(0);
        for (int num : nums) {
            sum += num;
            if (set.contains(sum - target)) {
                res++;
                set.clear();
                sum = 0;
            }
            set.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1546 solution1546 = new Solution1546();
        int[] a = {1, 1, 1, 1, 1};
        System.out.println(solution1546.maxNonOverlapping(a, 2));
    }

}