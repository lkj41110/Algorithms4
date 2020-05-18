package leetcode.tree;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 */
public class Solution1448 {

    int sum = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return sum;
    }

    public void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (max < root.val) {
            sum++;
        }
        dfs(root.right, root.val > max ? root.val : max);
        dfs(root.left, root.val > max ? root.val : max);

    }
}
