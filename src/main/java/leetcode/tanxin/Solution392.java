package leetcode.tanxin;


/**
 * 1234567
 * <p>
 *     f（x）=f
 */
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        if(t.length()==0){
            return false;
        }
        char[] a1 = s.toCharArray();
        char[] b1 = t.toCharArray();
        
        int a[][] = new int[a1.length+1][b1.length+1];
        //int res[][] = new int[a1.length + 1][b1.length + 1];

        //for (int i = 0; i <= a1.length; i++) {
        //    a[i][0] = 0;
        //}
        //for (int i = 0; i <= b1.length; i++) {
        //    a[0][i] = 0;
        //}
        for (int i = 1; i <= a1.length; i++) {
            for (int j = 1; j <= b1.length; j++) {
                int temp = a1[i-1 ] == b1[j-1 ] ? 1 : 0;
                a[i][j] = Math.max(a[i - 1][j - 1] + temp,a[i][j-1]);
                if(a[i][j]==s.length()){
                    return true;
                }
            }
        }
        return false;
    }
    /*
     */

    public static void main(String[] args) {
        Solution392 a = new Solution392();
        //Sstem.out.println(a.minDistance("123", "1234"));
        //Sstem.out.println(a.minDistance("horse", "ros"));
        //Sstem.out.println(a.minDistance("intention", "execution"));
        System.out.println(a.isSubsequence("abc", "ahbgdc"));
        System.out.println(a.isSubsequence("axc", "ahbgdc"));
        //Sstem.out.println(a.uniquePaths(7, 3));
    }
}