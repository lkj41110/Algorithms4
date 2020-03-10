package leetcode.tanxin;

public class Solution121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int max = 0;
        int maxNum = prices[0];
        int minNum = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > maxNum) {
                maxNum = prices[i];
                if(maxNum-minNum>max){
                    max = maxNum - minNum;
                }
            }else if(prices[i] < minNum){
                maxNum = prices[i];
                minNum = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution121 a = new Solution121();
        int[] b = {7,6,4,3,1};
        System.out.println(a.maxProfit(b));
    }
}