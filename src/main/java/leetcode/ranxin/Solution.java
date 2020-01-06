package leetcode.ranxin;

public class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0)
            return 0;
        int maxL = 0;
        int length = 0;

        int ss = 0, e = 0;
        int sum = 0;
        while (e < nums.length) {
            sum += nums[e];
            length++;
            if (sum >= s) {
                while (ss < e ) {
                    if (sum - nums[ss] >= s) {
                        sum -= nums[ss++];
                        length--;
                    } else {
                        break;
                    }
                }
                maxL = maxL == 0 ? length : Math.min(length, maxL);
            }
            e++;
        }
        return maxL;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int[] b = {2,3,1,2,4,3};
        System.out.println(a.minSubArrayLen(7, b));
    }
}