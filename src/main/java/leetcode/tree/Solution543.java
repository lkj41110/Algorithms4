package leetcode.tree;

/**
 * @author luokai
 * @description:
 * @date: 2019/2/28
 * @version: 1.0
 * <p>
 * [3,2,1,6,0,5]
 */
public class Solution543 {
    class Max{
        int value;

        public Max(int value) {
            this.value = value;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Max max = new Max(0);
        maxH(root, max);
        return max.value;
    }

    private int maxH(TreeNode root, Max max) {
        if (root == null) {
            return 0;
        }
        int r = maxH(root.right, max);
        int l = maxH(root.left, max);
        max.value = l +r > max.value ? l + r  : max.value;
        return r > l ? r + 1 : l + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new int[]{1,2,3,4,5});
        Solution543 solution = new Solution543();
        solution.diameterOfBinaryTree(treeNode);
    }
}
