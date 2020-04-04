package leetcode.tanxin;


/**
 * 1234567
 * <p>
 * 简单的动态规划
 */
class Solution72 {
    public int minDistance(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        int res[][] = new int[word2.length() + 1][word1.length() + 1];

        for (int i = 0; i <= chars1.length; i++) {
            res[0][i] = i;
        }
        for (int i = 0; i <= chars2.length; i++) {
            res[i][0] = i;
        }
        int temp = 0;
        for (int i = 1; i <= chars2.length; i++) {
            for (int j = 1; j <= chars1.length; j++) {
                temp = chars2[i - 1] == chars1[j - 1] ? 0 : 1;
                res[i][j] = res[i - 1][j - 1] + temp;
            }
        }

        return res[word2.length()][word1.length()];
    }

}