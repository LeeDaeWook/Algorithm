package programmers.p128711;

import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        long[][] answer = new long[n+1][m+1];

        for (int i = 0; i < n; i++) {
            if (isPuddle(i, 0, puddles))
                break;
            else
                answer[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (isPuddle(0, i, puddles))
                break;
            else
                answer[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (isPuddle(i, j, puddles))
                    answer[i][j] = 0;
                else
                    answer[i][j] = (answer[i-1][j] + answer[i][j-1]) % 1000000007;
            }
        }

        return (int) answer[n-1][m-1] % 1000000007;
    }

    private boolean isPuddle(int row, int col, int[][] puddles) {
        for (int[] puddle : puddles) {
            if (puddle[0] - 1 == col && puddle[1] - 1 == row)
                return true;
        }
        return false;
    }
}