package leetcode.bisai;

/**
 * 广搜， 多源发散
 */
public class Solution1_2 {
    public int countLargestGroup(int n) {
        int[] res = new int[50];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int a = resu(i);
            res[a]++;
            max = Math.max(max, res[a]);
        }
        int r=0;
        for(int i=0;i<res.length;i++){
            if(res[i]==max) r++;
        }
        return r;
    }

    private int resu(int n) {
        int sum = 0;
        while (n>0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1_2 a = new Solution1_2();
        int resu = a.resu(13);
    }
}