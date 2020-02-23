package leetcode.tree;

import java.util.List;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        Solution145 solution = new Solution145();
        //List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        solution.postorderTraversal(new TreeNode(new int[]{1, 2, 5, 3, 4, -1, 6}));
    }
}
