package leetcode.other;


/**
 * -10  1  2  3  9  10
 */
public class Solution31 {

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) return;
        int temp = nums[nums.length - 1];
        int i = nums.length - 2;
        for (i = nums.length - 2; i >= 0; i--) {
            //int chenge = chenge(nums, i, i - 1);
            if (nums[i] >= temp) {
                temp = nums[i];
                continue;
            } else {
                int t = i + 1;
                while (t < nums.length) {
                    if (nums[t] > nums[i]) {
                        t++;
                        continue;
                    } else break;
                }
                temp = nums[t - 1];
                nums[t - 1] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        chenge(nums, i + 1);

    }


    private void chenge(int[] nums, int i) {
        int e = nums.length - 1;
        while (i < e) {
            int temp = nums[i];
            nums[i] = nums[e];
            nums[e] = temp;
            i++;
            e--;
        }
    }

    public static void main(String[] args) {
        Solution31 solution = new Solution31();
        ////int[] a = {0, 0, 0};
        //int[] a = {2, 1, 2, 2, 2, 3, 4, 5, 6};
        //int[] a = {3,2,1};
        int[] a = {2, 3, 1};
        solution.nextPermutation(a);

    }


}