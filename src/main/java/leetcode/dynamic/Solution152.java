package leetcode.dynamic;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution152 {
    public int maxProduct(int[] nums) {
        int temp[][] = new int[nums.length][nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            temp[i][i] = nums[i];
            res = temp[i][i] > res ? temp[i][i] : res;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                temp[i][j] = (temp[i][j - 1] == 0 || temp[j][j] == 0) ? 0 : temp[i][j - 1] * temp[j][j];
                if (temp[i][j] > res) {
                    res = temp[i][j];
                }
            }
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int temp[] = new int[nums.length];
        temp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = temp[i - 1] * nums[i];
            res = temp[i] > res ? temp[i] : res;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                int t = temp[i] / temp[j];
                res = t > res ? t : res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int num[] = {1, 2, 3, 4};
        int treeNodes = solution152.maxProduct2(num);
        System.out.println(treeNodes);
    }
}