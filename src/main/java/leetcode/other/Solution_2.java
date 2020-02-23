package leetcode.other;


import java.util.ArrayList;
import java.util.List;

/**
 * -10  1  2  3  9  10
 */
public class Solution_2 {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        String a = null;
        Integer last_num = null;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (last_num == null) {
                last_num = nums[i];
                continue;
            } else {
                if (nums[i] == last_num + 1) {
                    last_num = nums[i];
                    flag = true;
                } else {
                    if (flag) {
                        a = last_num + "->" + nums[i - 1];
                    } else {
                        a = last_num + "";
                    }
                    list.add(a);
                    last_num = nums[i];
                }
            }
        }
        if (flag) {
            a = last_num + "->" + nums[nums.length - 1];
        } else {
            a = last_num + "";
        }
        list.add(a);
        return list;
    }


    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        //int[] a = {0, 0, 0};
        int[] a = {0, 1, 2, 4, 5, 7};
        List<String> strings = solution.summaryRanges(a);
        //int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        //System.out.println(solution.threeSum(b, 4));
    }


}