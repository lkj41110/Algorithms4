package leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小路径
 * 动态规划
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if (length == 0) {
            return 0;
        }
        int res[] = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            List<Integer> temp = triangle.get(i);
            for (int j = temp.size() - 1; j >= 0; j--) {
                if(j==0){
                    res[j] = res[j] + temp.get(j);
                }
                else {
                    res[j] = res[j] < res[j - 1] ? temp.get(j) + res[j] : temp.get(j) + res[j - 1];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            min = min < res[i] ? min : res[i];
        }
        return min;
    }

    public static void main(String[] args) {
        Solution120 solution = new Solution120();
        //int[][] a = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> a = new ArrayList<>();
        List<Integer> a1 = new ArrayList<>();
        a1.add(2);

        List<Integer> a2 = new ArrayList<>();
        a2.add(3);
        a2.add(4);

        a.add(a1);
        a.add(a2);
        System.out.println(solution.minimumTotal(a));
    }


}