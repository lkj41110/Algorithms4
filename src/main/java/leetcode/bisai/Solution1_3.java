package leetcode.bisai;

import java.util.Arrays;

//package leetcode.bisai;
//
///**
// * 广搜， 多源发散
// */
public class Solution1_3 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int len = satisfaction.length;
        if (satisfaction[len - 1] <= 0) return 0;
        int sum = 0;
        int num = 0;
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            num = num + satisfaction[i];
            sum = sum + num;
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1_3 s = new Solution1_3();
        System.out.println(s.maxSatisfaction(new int[]{-1, -8, 0, 5, -9}));
        System.out.println(s.maxSatisfaction(new int[]{-1,-4,-5}));
        System.out.println(s.maxSatisfaction(new int[]{-2,5,-1,0,3,-3}));
    }
}