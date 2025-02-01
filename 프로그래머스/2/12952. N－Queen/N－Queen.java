import java.util.*;
import java.lang.Math;

class Solution {
    int answer = 0;
    int QUEEN = 1;
    int EMPTY = 0;
    int[][] board;
    boolean[] column;

    public int solution(int n) {
        board = new int[n][n];
        column = new boolean[n];
        recursive(0, n);
        return answer;
    }
    
    public void recursive(int row, int n) {
        // 체스판의 끝까지 왔으면
        if (row == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[row][i] = QUEEN;
            if (!column[i] && isValid(row, i, n)) {
                column[i] = true;
                recursive(row+1, n);
                column[i] = false;
            }
            board[row][i] = EMPTY;
        }
    }
    
    public boolean isValid(int row, int col, int n) {
        // 대각선 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == QUEEN && Math.abs(i - row) == Math.abs(j - col) && i != row && j != col)
                    return false;
            }
        }

        return true;
    }
}