package leetcode.other;


/**
 * 289. 生命游戏
 * 进阶：
 * 原地算法
 */
public class Solution289 {

    public void gameOfLife(int[][] board) {

        int length_x = board.length;
        if (length_x <= 0) {
            return;
        }
        int length_y = board[0].length;
        if (length_y <= 0) {
            return;
        }
        int board_new[][] = new int[length_x][length_y];
        for (int i = 0; i < length_x; i++) {
            for (int j = 0; j < length_y; j++) {
                int sum = 0;
                if (i - 1 >= 0) {
                    sum += board[i - 1][j];
                    if (j - 1 >= 0) {
                        sum += board[i - 1][j - 1];
                    }
                    if (j + 1 < length_y) {
                        sum += board[i - 1][j + 1];
                    }
                }
                if (i + 1 < length_x) {
                    sum += board[i + 1][j];
                    if (j - 1 >= 0) {
                        sum += board[i + 1][j - 1];
                    }
                    if (j + 1 < length_y) {
                        sum += board[i + 1][j + 1];
                    }
                }
                if (j - 1 >= 0) {
                    sum += board[i][j - 1];

                }
                if (j + 1 < length_y) {
                    sum += board[i][j + 1];
                }
                if (sum < 2) {
                    board_new[i][j] = 0;
                } else if (sum > 3) {
                    board_new[i][j] = 0;
                }else if(sum==3){
                    board_new[i][j] = 1;
                }else{
                    board_new[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < length_x; i++) {
            for (int j = 0; j < length_y; j++) {
                board[i][j] = board_new[i][j];
            }
        }
    }



}