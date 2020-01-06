package leetcode.tanxin;


/**
 * 1234567
 * <p>
 * 简单的动态规划
 */
class Solution4 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        //res[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = 1;
                } else if (i == 0) {
                    res[i][j] = res[i][j - 1] ;
                } else if (j == 0) {
                    res[i][j] = res[i - 1][j] ;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }

        return res[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution4 a = new Solution4();
        System.out.println(a.uniquePaths(1, 1));
        System.out.println(a.uniquePaths(7, 3));
    }
}