package leetcode.dynamic;

/**
 * 最小路径
 * 动态规划
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        int s_l = s.length();
        int p_l = p.length();
        boolean[][] r = new boolean[s_l + 2][p_l + 2];
        r[0][0] = true;
        //for (int i = 0; i < s_l; i++) {
        //    r[i + 1][0] = true;
        //}
        boolean flag = false;
        for (int i = 0; i < p_l; i++) {
            if (i == 0 && p.charAt(i) == '*') {
                r[0][i + 1] = true;
                flag = true;
            } else if (p.charAt(i) == '*' && r[0][i]) {
                r[0][i + 1] = true;
                flag = true;
            }
        }
        for (int i = 0; i < p.length(); i++) {
            char ch1 = p.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                char ch2 = s.charAt(j);
                if (ch1 == '*') {
                    r[j + 1][i + 1] = r[j][i + 1] || r[j + 1][i] || r[j][i];
                    flag = true;
                } else if (ch1 == '?') {
                    r[j + 1][i + 1] = r[j][i];
                } else {
                    if (ch1 != ch2) {
                        r[j + 1][i + 1] = false;
                    } else {
                        r[j + 1][i + 1] = r[j][i];
                    }
                }
            }
        }
        if (!flag && s.length() != p.length()) {
            return false;
        }
        return r[s_l][p_l];
    }
    //
    //public static void main(String[] args) {
    //    Solution44 sl = new Solution44();
    //    System.out.println(sl.isMatch("123", "") + "  false");
    //    System.out.println(sl.isMatch("aa", "a") + "  false");
    //    System.out.println(sl.isMatch("aa", "aa") + "  true");
    //    System.out.println(sl.isMatch("aa", "*") + "  true");
    //    System.out.println(sl.isMatch("cb", "?a") + "  false");
    //    System.out.println(sl.isMatch("adceb", "*a*b") + "  true");
    //    System.out.println(sl.isMatch("acdcb", "a*c?b") + "  false");
    //    System.out.println(sl.isMatch("aab", "c*a*b") + "  false");
    //
    //    System.out.println(sl.isMatch("a", "a*") + "  true");
    //    System.out.println(sl.isMatch("aaab", "b**") + "  true");
    //
    //}

}