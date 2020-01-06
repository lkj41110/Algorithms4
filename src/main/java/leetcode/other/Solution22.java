package leetcode.other;


import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 1
 * (  )
 *
 * <p>
 * 2
 * ()
 */
public class Solution22 {

    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        //dfs(r, n, "");
        dfs(r, n - 1, 1, "(");
        return r;
    }

    private void dfs(List<String> r, int n, int e, String a) {
        if (n == 0) {
            while (e > 0) {
                a = a + ")";
                e--;
            }
            r.add(a);
            return;
        }

        String temp = "";
        dfs(r, n - 1, e + 1, a + temp + "(");
        for (int i = 1; i <= e; i++) {
            temp = temp + ")";
            dfs(r, n - 1, e - i + 1, a + temp + "(");
        }
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Solution22 so = new Solution22();
        List<String> permute = so.generateParenthesis(3);
        System.out.println(permute);
    }


}