package leetcode.other;


import leetcode.tree.TreeNode;

/**
 *
 */
public class Solution98 {

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    public static void main(String[] args) {
        Solution98 su = new Solution98();
        int[] a = new int[]{2, 1, 3};
        TreeNode root = new TreeNode(a);
        boolean validBST = su.isValidBST(root);
        System.out.println(validBST);
    }


}