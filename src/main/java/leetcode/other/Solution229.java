package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 投票法
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int temp1 = 0, temp2 = 0;
        int num1 = 0, num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num1 == 0 && num2 == 0) {
                num1++;
                temp1 = nums[i];
            } else if (num1 == 0) {
                if (temp2 == nums[i]) {
                    num2++;
                } else {
                    num1++;
                    temp1 = nums[i];
                }
            } else if (num2 == 0) {
                if (temp1 == nums[i]) {
                    num1++;
                } else {
                    num2++;
                    temp2 = nums[i];
                }
            } else {
                if (temp1 == nums[i]) {
                    num1++;
                } else if (temp2 == nums[i]) {

                    num2++;
                } else {
                    num1--;
                    num2--;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        if(num1!=0){
            list.add(temp1);
        }
        if(num2!=0){
            list.add(temp2);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution229 s = new Solution229();
        s.majorityElement(new int[]{});
    }
}