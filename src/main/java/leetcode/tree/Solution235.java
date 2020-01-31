package leetcode.tree;

import java.util.Stack;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * 个人想法是找出两个节点的深度，然后再找出对应的父节点
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 */
public class Solution235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (stack.size() > 0) {
            TreeNode parent = stack.pop();
            if ((p.val < parent.val && q.val > parent.val) || (q.val < parent.val && p.val > parent.val)) {
                return parent;
            } else if (p.val < parent.val && q.val < parent.val) {
                stack.push(parent.left);
            } else if (p.val > parent.val && q.val > parent.val) {
                stack.push(parent.right);
            } else if (p.val == parent.val || q.val == parent.val) {
                return parent;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution235 solution = new Solution235();
        TreeNode treeNode = new TreeNode(new int[]{3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4});
        solution.lowestCommonAncestor(treeNode, new TreeNode(5), new TreeNode(1));
    }

}
