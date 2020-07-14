package leetcode.dynamic.股票;

/**
 * 简单股票问题
 * 动态规划
 */
public class Solution120 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length + 1][2][2];
        dp[0][1][1] = 0 - prices[0];
        dp[0][0][0] = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int k = 1; k >= 1; k--) {
                dp[i + 1][k][0] = Math.max(dp[i][k][0], dp[i][k][1] + prices[i]);
                dp[i + 1][k][1] = Math.max(dp[i][k][1], dp[i][k - 1][0] - prices[i]);
            }
        }

        return dp[prices.length][1][0];
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }

        int[][][] dp = new int[prices.length + 1][k + 1][2];

        for (int i = 0; i < prices.length; i++) {
            dp[i ][0][0] = 0;//至今为止没有交易，收益为0
            dp[i ][0][1] = Integer.MIN_VALUE;//交易了0次，但持有股票，不符合规则
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k][0];
    }

    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        int[] a = {2, 4, 1};
        System.out.println(solution120.maxProfit(2, a));
    }
}