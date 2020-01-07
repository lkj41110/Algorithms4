package leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 */
public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        dfs(r, candidates, target, tem, 0);
        return r;
    }

    private void dfs(List<List<Integer>> r, int[] candidates, int target, ArrayList<Integer> tem, int s) {
        if (target == 0) {
            r.add(new ArrayList<>(tem));
            return;
        }
        for (int i = s; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            tem.add(candidates[i]);
            dfs(r, candidates, target - candidates[i], tem, i);
            tem.remove(tem.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        //List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}
