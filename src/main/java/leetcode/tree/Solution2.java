package leetcode.tree;

/**
 * @author luokai
 * @description:
 * @date: 2019/2/28
 * @version: 1.0
 * <p>
 * [3,2,1,6,0,5]
 */
public class Solution2 {
    public TreeNode pruneTree(TreeNode root) {
        check(root);
        return root;
    }

    boolean check(TreeNode treeNode) {
        if (treeNode.left == null && treeNode.right == null && treeNode.val == 0) {
            return false;
        }
        boolean flag1 = false;
        boolean flag2 = false;
        if (treeNode.left != null) {
            flag1 = check(treeNode.left);
            if (!flag1) {
                treeNode.left = null;
            }
        }
        if (treeNode.right != null) {
            flag2 = check(treeNode.right);
            if (!flag2) {
                treeNode.right = null;
            }
        }
        return flag1 | flag2 | treeNode.val == 1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        TreeNode treeNode = new TreeNode(new int[]{1, -1, 0, 0, 1});
        solution.pruneTree(treeNode);
    }
}
