package leetcode.other;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * -10  1  2  3  9  10
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3)
            return lists;
        Arrays.sort(nums);
        int a, b, c;
        for (a = 0; a < nums.length - 2; ) {
            b = a + 1;
            c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                if (sum == 0) {
                    List l = new ArrayList();
                    l.add(nums[a]);
                    l.add(nums[b]);
                    l.add(-(nums[a] + nums[b]));
                    lists.add(l);
                    do {
                        b++;
                    }
                    while (b < c && nums[b] == nums[b - 1]);
                    do {
                        c--;
                    }
                    while (b < c && nums[c] == nums[c + 1]);
                } else if (sum > 0) {
                    do {
                        c--;
                    }
                    while (b < c && nums[b] != nums[c] && nums[c] == nums[c + 1]);
                } else if (sum < 0) {
                    do {
                        b++;
                    }
                    while (b < c && nums[b] != nums[c] && nums[b] == nums[b - 1]);
                }
            }
            do {
                a++;
            }
            while (nums[a] == nums[a - 1] && a <= nums.length - 2);
        }
        return lists;
    }


    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        //int[] a = {0, 0, 0};
        int[] a = {0, 2, 2, 3, 0, 1, 2, 3, -1, -4, 2};
        System.out.println(solution.threeSum(a));
        //int[] b = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        //System.out.println(solution.threeSum(b, 4));
    }


}