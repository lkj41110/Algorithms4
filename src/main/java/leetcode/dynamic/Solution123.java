package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 股票 通用模式
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int maxK = 2, n = prices.length;
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k <= maxK; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    //dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                    //dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
                    continue;
                }
                if (k == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][maxK][0];
    }

    public static void main(String[] args) {
        Solution123 solution = new Solution123();
        //int[][] a = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(solution.minimumTotal(a));
    }


}