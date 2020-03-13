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
        //检查两个票数符不符合
        num1 = num2 = 0;
        for (int num : nums) {
            if (num == temp1) {
                num1++;
            } else if (num == temp2) {
                //这里一定要用else if，因为可能出现[0,0,0]这种用例，导致两个cand是一样的，写两个if结果就变为[0,0]了
                num2++;
            }
        }

        List<Integer> list = new ArrayList<>();
        if(num1>nums.length/3){
            list.add(temp1);
        }
        if(num2>nums.length/3){
            list.add(temp2);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution229 s = new Solution229();
        s.majorityElement(new int[]{});
    }
}