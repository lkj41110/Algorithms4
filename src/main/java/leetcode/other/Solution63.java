package leetcode.other;

/**
 * 深搜
 */
public class Solution63 {
    //方法1，笨重
    public int countBinarySubstrings(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            int len = 1;
            char a = '0';
            while (i + len - 1 < s.length() && i - len >= 0) {
                if (s.charAt(i + len - 1) != s.charAt(i - len)) {
                    if (len == 1) {
                        a = s.charAt(i + len - 1);
                        res++;
                    } else if (a == s.charAt(i + len - 1)) {
                        res++;
                    } else {
                        break;
                    }
                    len++;
                } else {
                    break;
                }
            }
        }
        return res;
    }

    //方法1，笨重
    public int countBinarySubstrings1(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int now = 0;
        int la = 0;
        char la_ch = 'a';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (now == 0) {
                now++;
                la_ch = ch;
            } else if (ch == la_ch) {
                now++;
            } else {
                if (la == 0) {
                    la = now;
                } else {
                    res += Math.min(la, now);
                }
                now = 1;
                la_ch = ch;
            }
        }
        if (la != 0) {
            res += Math.min(la, now);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution63 so = new Solution63();
        int[][] a = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int i = so.countBinarySubstrings1("00110011");
        System.out.println(i);
    }
}