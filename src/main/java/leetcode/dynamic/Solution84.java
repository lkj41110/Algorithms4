package leetcode.dynamic;

/**
 * 最小路径
 * 动态规划
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        if (heights.length == 0) {
            return 0;
        }
        int[][] temp = new int[heights.length][heights.length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j <= i; j++) {
                int value = 0;
                if (i == j) {
                    temp[j][i] = heights[i];
                    value = heights[i];
                } else {
                    temp[j][i] = Math.min(temp[j][i - 1], heights[i]);
                    value = temp[j][i] * (i - j+1);
                }
                max = Math.max(value, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution84 so = new Solution84();
        int[] a = {2, 1, 5, 6, 2, 3,3,3};
        System.out.println(so.largestRectangleArea(a));
    }


}