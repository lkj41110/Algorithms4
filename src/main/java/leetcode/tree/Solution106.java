package leetcode.tree;


public class Solution106 {


    private TreeNode gouZao(int s2, int e2, int s1, int e1, int[] str1, int[] str2) {
        if (s2 > e2) {
            return null;
        }
        if (s2 == e2) {
            return new TreeNode(str2[s2]);
        }
        int ch = str2[e2];
        TreeNode treeNode = new TreeNode(ch);

        int index = indexOf(ch, str1);

        treeNode.left = gouZao(s2, s2 + index - s1 - 1, s1, index - 1, str1, str2);
        treeNode.right = gouZao(s2 + index - s1, e2 - 1, index + 1, e1, str1, str2);
        return treeNode;
    }

    private int indexOf(int a, int[] a1) {
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return gouZao(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public static void main(String[] args) {
        Solution106 solution_temp = new Solution106();
        TreeNode treeNode = solution_temp.buildTree(null, null);
        //TreeNode treeNode = solution_temp.getTreeNode("DBEAC", "DEBCA");
    }

    //
    //private TreeNode gouZao(int s2, int e2, int s1, int e1, String str1, String str2) {
    //    if (s2 > e2) {
    //        return null;
    //    }
    //    if (s2 == e2) {
    //        return new TreeNode(str2.charAt(s2));
    //    }
    //    char ch = str2.charAt(s2);
    //    TreeNode treeNode = new TreeNode(ch);
    //
    //    int index = str1.indexOf(ch);
    //
    //    treeNode.left = gouZao(s2, s2 + index - s1, s1, index - 1, str1, str2);
    //    treeNode.right = gouZao(s2 + index - s1 + 1, e2 - 1, index + 1, e1, str1, str2);
    //    return treeNode;
    //}
    //
    //public TreeNode getTreeNode(String str1, String str2) {
    //    return gouZao(0, str2.length()-1, 0, str1.length() - 1, str1, str2);
    //}
    //
    //public static void main(String[] args) {
    //    Solution_temp solution_temp = new Solution_temp();
    //    TreeNode treeNode = solution_temp.getTreeNode("DBEAC", "DEBCA");
    //}

}



















