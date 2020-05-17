package leetcode.dynamic;

import java.util.HashMap;

/**
 * 最小路径
 * 动态规划
 */
public class Solution560 {
    //动态规划
    public int subarraySum1(int[] nums, int k) {
        if (nums.length <= 0) {
            return 0;
        }

        int d[][] = new int[nums.length][nums.length];


        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            d[i][i] = nums[i];
            if (d[i][i] == k) {
                res++;
            }

            for (int j = 0; j < i; j++) {
                int sum = d[j][i - 1] + nums[i];
                d[j][i] = sum;
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            int index = sum - k;
            Integer value = map.get(index);
            if (value != null) {
                res += value;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        int[] a = {1, 1, 1};
        System.out.println(solution560.subarraySum(a, 2) + "==2");
        int[] a1 = {1, 2, 1};
        System.out.println(solution560.subarraySum(a1, 2) + "==1");
    }

}