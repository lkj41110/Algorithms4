package leetcode.tree;

/**
 * @author luokai
 * @description:
 * @date: 2019/2/28
 * @version: 1.0
 * <p>
 * [3,2,1,6,0,5]
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;

        return create(nums, 0, nums.length - 1);
    }

    private TreeNode create(int[] nums, int s, int e) {
        if (s > e)
            return null;
        if (s == e)
            return new TreeNode(nums[s]);
        int maxIndex = getMaxIndex(nums, s, e);
        TreeNode node = new TreeNode(nums[maxIndex]);
        TreeNode leftNode = create(nums, s, maxIndex - 1);
        TreeNode rightNode = create(nums, maxIndex + 1, e);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    private int getMaxIndex(int[] nums, int s, int e) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = s; i <= e; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }
}
