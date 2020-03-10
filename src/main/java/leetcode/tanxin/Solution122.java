package leetcode.tanxin;

public class Solution122 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max = max + prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution122 a = new Solution122();
        int[] b = {1,2,3,4,5};
        System.out.println(a.maxProfit(b));
    }
}