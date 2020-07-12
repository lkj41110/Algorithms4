package leetcode.erfen;

import java.util.LinkedList;
import java.util.List;

public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }

        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int a = sort(nums, i, nums.length);
            res.addFirst(a);
        }
        return res;
    }

    private int sort(int[] nums, int index, int length) {
        int temp = nums[index];
        int r = 0;
        for (int i = index + 1; i < length; i++) {
            if (temp > nums[i]) {
                r++;
                swap(i, i - 1, nums);
            } else break;

        }
        return r;
    }

    private void swap(int i, int index, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
    }

    public static void main(String[] args) {
        Solution315 solution = new Solution315();
        int[] x = {5, 2, 10, 4, 1, 6, 1};
        List<Integer> integers = solution.countSmaller(x);
    }
}