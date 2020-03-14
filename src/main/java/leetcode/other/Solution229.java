package leetcode.other;


/**
 * 投票法
 */
public class Solution229 {
    public class Point {
        int i;
        int j;
    }

    public void solve(char[][] board) {
        int h = board.length;
        if (h == 0) {
            return;
        }
        int w = board[0].length;
        if (w == 0) {
            return;
        }
        int temp[][] = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; i < w; j++) {
                //遍历过
                if (temp[i][j] == 1) {
                    continue;
                }
                //不是
                if (board[i][j] == 'X') {
                    continue;
                }

            }
        }

    }

    public static void main(String[] args) {
        Solution229 s = new Solution229();
        //s.solve(new int[]{});
    }
}