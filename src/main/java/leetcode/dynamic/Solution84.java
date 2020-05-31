package leetcode.dynamic;

import java.util.Stack;

/**
 * 最小路径
 * 动态规划
 */
public class Solution84 {
    public int largestRectangleArea1(int[] heights) {
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
                    value = temp[j][i] * (i - j + 1);
                }
                max = Math.max(value, max);
            }
        }
        return max;
    }


    public int largestRectangleArea(int[] heights) {
        int max = 0;
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            while (stack.size() != 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(i);
        }

        Stack<Integer> stack1 = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack1.size() != 0 && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            right[i] = stack1.size() == 0 ? heights.length  : stack1.peek();
            stack1.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i]-1) * heights[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution84 so = new Solution84();
        int[] a = {2,1,5,6,2,3,3,3};
        System.out.println(so.largestRectangleArea(a));
    }


}