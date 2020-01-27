package leetcode.other;


import leetcode.tree.TreeNode;

/**
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * 1
 * / \
 * 2   3
 * / \  /
 * 4  5 6
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLevelL(root.left);
        int right = countLevelR(root.right);
        //左边等于右边
        if (left == right) {
            return (1 << (left + 1)) - 1;
        } else {
            //左边不等于右边
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    private int countLevelL(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

    private int countLevelR(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.right;
        }
        return level;
    }

    public static void main(String[] args) {
        Solution222 solution222 = new Solution222();
        int[] ints = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(solution222.countNodes(new TreeNode(ints)));
    }


}