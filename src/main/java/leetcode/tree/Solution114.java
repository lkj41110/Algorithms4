package leetcode.tree;

/**
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 先序遍历
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode treeNode = new TreeNode(root.val);
        dfs(root, treeNode);
        root.left = null;
        root.right = treeNode.right.right;
    }

    private TreeNode dfs(TreeNode node, TreeNode last) {
        //
        if (node == null) {
            return last;
        }
        TreeNode treeNode = new TreeNode(node.val);
        last.right = treeNode;
        last = last.right;
        last = dfs(node.left, last);
        last = dfs(node.right, last);
        return last;
    }


    public static void main(String[] args) {
        Solution114 solution = new Solution114();
        //List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        solution.flatten(new TreeNode(new int[]{1, 2, 5, 3, 4, -1, 6}));
        //System.out.println(lists);
    }
}
