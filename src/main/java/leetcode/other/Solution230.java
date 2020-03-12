package leetcode.other;

import leetcode.tree.TreeNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 * 先序遍历  根节点-1即可
 */
public class Solution230 {
    int tempK;

    public int kthSmallest(TreeNode root, int k) {
        Integer res = null;
        tempK = k;
        return dfs(root, res);
    }

    private Integer dfs(TreeNode root, Integer r) {
        if (root == null) {
            return null;
        }
        r = dfs(root.left, r);
        if (r != null) {
            return r;
        }
        tempK--;
        if (tempK == 0) {
            return root.val;
        }
        r = dfs(root.right, r);
        if (r != null) {
            return r;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution230 s = new Solution230();
        s.kthSmallest(new TreeNode(new int[]{5, 3, 6, 2, 4, -1, -1, 1}), 3);
    }
}