package leetcode.tanxin;


/**
 * 1234567
 * <p>
 * f（x）=f
 */
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        char[] a1 = s.toCharArray();
        char[] b1 = t.toCharArray();

        int a[][] = new int[a1.length + 1][b1.length + 1];
        for (int i = 1; i <= a1.length; i++) {
            for (int j = 1; j <= b1.length; j++) {
                int temp = a1[i - 1] == b1[j - 1] ? 1 : 0;
                a[i][j] = Math.max(a[i - 1][j - 1] + temp, a[i][j - 1]);
                if (a[i][j] == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}