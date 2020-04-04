package leetcode.bisai;

/**
 * 广搜， 多源发散
 */
public class Solution1_1 {
    public boolean canConstruct(String s, int k) {
        char[] a = s.toCharArray();
        int len = a.length;
        if (len < k) return false;
        if (len == k) return true;

        int[] res = new int[58];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int index = a[i] - 'A';
            res[index]++;
            if (res[index] == 2) {
                res[index] = 0;
                sum--;
            } else {
                sum++;
            }
        }
        if (sum <= k) {
            return true;
        }
        return false;
    }

    //
    //private boolean f(char[] a, int k, int s_a, int s_e) {
    //    if (k == 0 && s_a == s_e) {
    //        return true;
    //    } else if (k <= 0) {
    //        return false;
    //    }
    //    for (int i = s_a; i <= s_e; i++) {
    //        if (check(a, s_a, i)) {
    //            boolean f = f(a, k - 1, i + 1, s_e);
    //            if (f) return true;
    //        }
    //    }
    //    return false;
    //}
    //
    //private boolean check(char[] a, int s_a, int s_e) {
    //    int s = s_a, e = s_e;
    //    while (s < e) {
    //        if (a[s++] != a[e--]) {
    //            return false;
    //        }
    //    }
    //    return true;
    //}
    //
    public static void main(String[] args) {
        Solution1_1 a = new Solution1_1();
        System.out.println(a.canConstruct("leertcode", 3));
        System.out.println(a.canConstruct("annabelle", 2));
        System.out.println(a.canConstruct("yzyzyzyzyzyzyzy", 2));
    }
}