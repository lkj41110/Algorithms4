package leetcode.dynamic;

/**
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * 简单动态规划， 左子树*右子树
 */
public class Solution96 {
    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if(n==0){
            return 0;
        }
        int res[] = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                temp = temp + res[j] * res[i - 1 - j];
            }
            res[i] = temp;
        }

        return res[n];
    }

    public static void main(String[] args) {
        Solution96 solution = new Solution96();
        //int[][] a = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.numTrees(3));
    }


}