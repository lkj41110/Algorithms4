package leetcode.dynamic;

/**
 * 摘樱桃
 * 反向  动态规划
 * <p>
 * 正反两条路 放弃。。。。
 */
public class Solution647 {

    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        if (s.length() <= 1) {
            return s.length();
        }
        int res[] = new int[chars.length];
        int res1[][] = new int[chars.length][chars.length];
        for (int i = 0; i < chars.length; i++) {
            res1[i][i] = 1;
        }
        res[0] = 1;

        for (int i = 1; i < res.length; i++) {
            int num = 1;
            for (int j = 0; j < i; j++) {
                if (chars[j] == chars[i] && (i - 1 <= j + 1 || res1[j + 1][i - 1] == 1)) {
                    num++;
                    res1[j][i] = 1;
                }
            }
            res[i] = res[i - 1] + num;
        }
        return res[chars.length - 1];
    }


}