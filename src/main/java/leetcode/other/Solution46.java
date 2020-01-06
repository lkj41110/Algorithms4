package leetcode.other;


import java.util.ArrayList;
import java.util.List;

/**
 * 全排序
 * 常规递归题目
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        dfs(r, 0, nums);
        return r;
    }

    private void dfs(List<List<Integer>> r, int j, int[] nums) {
        if (j == nums.length) {
            show(r, nums);
        }

        for (int i = j; i < nums.length; i++) {
            swap(nums, i, j);
            dfs(r, j + 1, nums);
            swap(nums, i, j);
        }
    }

    private void show(List<List<Integer>> r, int[] nums) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            a.add(nums[i]);
        }
        r.add(a);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        Solution46 so = new Solution46();
        List<List<Integer>> permute = so.permute(a);
        System.out.println(permute);
    }


}