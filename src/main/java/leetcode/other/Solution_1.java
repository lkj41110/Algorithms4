package leetcode.other;


/**
 * -10  1  2  3  9  10
 */
public class Solution_1 {

    public void moveZeroes(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int b = 0; //记录0的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {

            } else {
                int temp = nums[b];
                nums[b] = nums[i];
                nums[i] = temp;
                b++;
            }
        }
    }


    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        //int[] a = {0, 0, 0};
        int[] a = {0, 1, 0, 3, 12};
        solution.moveZeroes(a);
        //int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        //System.out.println(solution.threeSum(b, 4));
    }


}