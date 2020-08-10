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
        for (int i = 1; i < s.length() ; i++) {
            int len = 1;
            char a = '0';
            while (i + len - 1 < s.length() && i - len >= 0) {
                if (s.charAt(i + len - 1) != s.charAt(i - len)) {
                    if (len == 1) {
                        a = s.charAt(i + len - 1);
                        res++;
                    } else if (a == s.charAt(i + len - 1)) {
                        res++;
                    }else{
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

    public static void main(String[] args) {
        Solution63 so = new Solution63();
        int[][] a = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int i = so.countBinarySubstrings("10101");
        System.out.println(i);
    }
}