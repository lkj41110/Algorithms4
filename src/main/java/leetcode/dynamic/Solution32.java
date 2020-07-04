package leetcode.dynamic;

import java.util.Stack;

/**
 * 最小路径 https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 动态规划
 */
public class Solution32 {
    public int longestValidParentheses(String s) {
        int[] a = new int[s.length()];
        int max = 0;
        int la = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(la);
                la = 0;
            } else {
                if (stack.size() == 0) {
                    la = 0;
                    stack.clear();
                    continue;
                } else {
                    Integer pop = stack.pop();
                    la = pop + 2 + la;
                    max = Math.max(max, la);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution32 s = new Solution32();
        System.out.println(s.longestValidParentheses("(()") + "   2");
        System.out.println(s.longestValidParentheses(")()())") + "   4");
        System.out.println(s.longestValidParentheses("())(())") + "   4");

    }


}