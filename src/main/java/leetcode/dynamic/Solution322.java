package leetcode.dynamic;

/**
 * 动态规划
 * 两种方程式
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int res[] = new int[amount + 1];
        if (amount == 0) {
            return 0;
        }
        for (int i = 1; i <= amount; i++) {
            if (res[i] == 1) {
                continue;
            }
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0) {
                    continue;
                } else if (i - coins[j] == 0) {
                    res[i] = 1;
                    break;
                } else {
                    if (res[i - coins[j]] == 0 || res[i - coins[j]] == -1) {
                        continue;
                    } else {
                        res[i] = res[i - coins[j]] + 1 < res[i] ? res[i - coins[j]] + 1 : res[i];
                    }
                }
            }

        }
        return res[amount] == Integer.MAX_VALUE ? -1 : res[amount];
    }

    public static void main(String[] args) {
        Solution322 solution = new Solution322();
        //int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[] a = {1, 2, 5};

        System.out.println(solution.coinChange(a, 11));

    }


}