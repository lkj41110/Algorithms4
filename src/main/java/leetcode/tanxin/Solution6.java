package leetcode.tanxin;


/**
 * 1234567
 * <p>
 * 简单的动态规划
 */
class Solution6 {
    public int maximalRectangle(char[][] matrix) {
        int h = matrix.length;
        int w = matrix[0].length;
        int[][][][] res = new int[h][w][h][w];
        int max = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                //终点
                if (matrix[i][j] != '1') {
                    continue;
                }

                for (int e_i = i; e_i < h; e_i++) {
                    for (int e_j = j; e_j < w; e_j++) {
                        if (i == e_i && j == e_j) {
                            continue;
                        }


                    }
                }
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        Solution6 a = new Solution6();
        //System.out.println(a.minDistance("123", "1234"));
        //System.out.println(a.minDistance("horse", "ros"));
        //System.out.println(a.minDistance("intention", "execution"));
        //System.out.println(a.uniquePaths(7, 3));
    }
}