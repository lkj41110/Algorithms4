package leetcode.dynamic;

class Solution300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int res[] = new int[nums.length];
        res[0] = nums[0];
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = num; j >= 0; j--) {
                if (nums[i] > res[j]) {
                    res[j + 1] = nums[i];
                    if (j + 1 > num) {
                        num = j + 1;
                    }
                    break;
                }
                if (nums[i] == res[i]) break;
                if (j == 0) {
                    res[0] = nums[i];
                }
            }
        }
        return num + 1;
    }

    public static void main(String[] args) {
        Solution300 solution = new Solution300();
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.lengthOfLIS(a));
    }
}