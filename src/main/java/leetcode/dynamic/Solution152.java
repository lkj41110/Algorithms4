package leetcode.dynamic;


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

    /**
     * 三刷
     * n 复杂度
     *
     * @param nums
     * @return
     */
    public int maxProduct3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int re_max = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tMax = max * nums[i];
            int tMin = min * nums[i];

            max = Math.max(nums[i], Math.max(tMin, tMax));
            min = Math.min(nums[i], Math.min(tMin, tMax));
            re_max = Math.max(re_max, max);

        }
        return re_max;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        int num[] = {1, 2, 3, 4};
        System.out.println(solution152.maxProduct3(num) + " == " + 24);


        int num1[] = {-5,-2,7};
        System.out.println(solution152.maxProduct3(num1) + " == " + 70);

        int num2[] = {5,-2,7};
        System.out.println(solution152.maxProduct3(num2) + " == " + 7);

        int num3[] = {2,3,-2,4};
        System.out.println(solution152.maxProduct3(num3) + " == " + 6);

    }
}