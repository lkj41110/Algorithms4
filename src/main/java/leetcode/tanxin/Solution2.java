package leetcode.tanxin;

/**
 * 加油站
 * 1.总和 大于等于 0
 * 2.
 * 1 3 2 2 1
 */
class Solution2 {
    //public int wiggleMaxLength(int[] nums) {
    //    if (nums.length <= 1) {
    //        return nums.length;
    //    }
    //    int temp = nums[0];
    //    Boolean flag = null;
    //    int res = 1;
    //    for (int i = 1; i < nums.length; i++) {
    //        if (nums[i] > temp) {
    //            if (flag == null || flag == false) {
    //                res++;
    //                temp = nums[i];
    //                flag = true;
    //            } else {
    //                temp = nums[i];
    //            }
    //
    //        } else if (temp > nums[i]) {
    //            if (flag == null || flag == true) {
    //                res++;
    //                temp = nums[i];
    //                flag = false;
    //            } else {
    //                temp = nums[i];
    //            }
    //        } else if (nums[i] == temp) {
    //            continue;
    //        }
    //    }
    //    return res;
    //}

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution2 a = new Solution2();
        int[] b = {0, 1,2,3,4,5,6,7};
        System.out.println(a.wiggleMaxLength(b));
    }
}