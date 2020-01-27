package leetcode.dynamic;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 输入:
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 */
public class Solution347 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int max = 0;
        int res[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || j == 0) {
                    res[i][j] = matrix[i][j] == '1' ? 1 : 0;
                    max = res[i][j] > max ? res[i][j] : max;
                    continue;
                }
                res[i][j] = matrix[i][j] == '1' ? getMin(res[i - 1][j], res[i][j - 1], res[i - 1][j - 1]) + 1 : 0;
                max = res[i][j] > max ? res[i][j] : max;
            }
        }
        return max;
    }

    private int getMin(int value1, int value2, int value3) {
        int min = value1 > value2 ? value2 : value1;
        min = min > value3 ? value3 : min;
        return min;
    }

    public static void main(String[] args) {
        Solution347 solution = new Solution347();
        /* 1 0 1 0 0
         * 1 0 1 1 1
         * 1 1 1 1 1
         * 1 0 0 1 0
         */
        //["1","0","1","0","0"]
        //["1","0","1","1","1"]
        //["1","1","1","1","1"]
        //["1","0","0","1","0"]]
        //char[][] a = {{'1', '0', '1', '0', '0'},
        //        {'1', '0', '1', '1', '1'},
        //        {'1', '1', '1', '1', '1'},
        //        {'1', '0', '1', '1', '1'}};

        char[][] a = {{'1'}};
        System.out.println(solution.maximalSquare(a));
    }


}