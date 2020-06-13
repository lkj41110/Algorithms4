package leetcode.tree;


public class Solution94_ {


    private TreeNode test(int[] a, int[] b) {
        return dfs(a, b, 0, a.length - 1, 0, b.length - 1);
    }

    private TreeNode dfs(int[] a, int[] b, int as, int ae, int bs, int be) {
        if (ae < as) {
            return null;
        }
        if (as == ae) {
            return new TreeNode(a[ae]);
        }
        TreeNode treeNode = new TreeNode(a[as]);
        int value = a[as + 1];
        for (int i = bs; i <= be; i++) {
            if (b[i] == value) {
                int l1 = i - bs;
                int l2 = be - 1 - i;
                treeNode.left = dfs(a, b, as + 1, as + l1 + 1, bs, i);
                treeNode.right = dfs(a, b, as + l1 + 2, ae, i + 1, be - 1);
            }
        }

        return treeNode;
    }

    public static void main(String[] args) {
        Solution94_ a = new Solution94_();
        int[] a1 = {1, 2, 4, 5, 3, 6};
        int[] a2 = {4, 5, 2, 6, 3, 1};
        TreeNode test = a.test(a1, a2);
    }

}
