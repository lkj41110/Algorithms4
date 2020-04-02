package leetcode.dynamic;

/**
 * 最小路径
 * 反向  动态规划
 */
public class Solution174 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[m - 1][n - 1] = grid[m - 1][n - 1] >= 0 ? 0 : grid[m - 1][n - 1];
        for (int i = m - 2; i >= 0; i--) {
            res[i][n - 1] = res[i + 1][n - 1] + grid[i][n - 1];
            res[i][n - 1] = res[i][n - 1] >= 0 ? 0 : res[i][n - 1];
        }
        for (int j = n - 2; j >= 0; j--) {
            res[m - 1][j] = res[m - 1][j + 1] + grid[m - 1][j];
            res[m - 1][j] = res[m - 1][j] >= 0 ? 0 : res[m - 1][j];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                res[i][j] = Math.max(res[i][j + 1], res[i + 1][j]) + grid[i][j];
                res[i][j] = res[i][j] >= 0 ? 0 : res[i][j];
            }
        }
        return res[0][0] > 0 ? 0 : 0 - res[0][0] + 1;
    }

}