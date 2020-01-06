package leetcode.other;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 假设有n个数
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> r = new ArrayList<>((int) Math.pow(2, length));

        r.add(new ArrayList<>());

        for (int j = 0; j < nums.length; j++) {
            List<List<Integer>> new1 = new ArrayList<>();

            for (int i = 0; i < r.size(); i++) {
                List<Integer> integers = r.get(i);
                LinkedList<Integer> integers1 = new LinkedList<>(integers);
                integers1.add(nums[j]);
                new1.add(integers1);
            }

            r.addAll(new1);
        }
        return r;
    }


    public static void main(String[] args) {
        Solution78 su = new Solution78();
        int[] a = new int[]{1, 2, 3};
        List<List<Integer>> subsets = su.subsets(a);
    }


}