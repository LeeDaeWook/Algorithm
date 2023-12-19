package programmers.p43105;

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int row = 1; row < triangle.length; row++) {
            for (int col = 0; col < triangle[row].length; col++) {
                if (col == 0)
                    dp[row][col] = dp[row-1][col] + triangle[row][col];
                else if (col == triangle[row].length - 1)
                    dp[row][col] = dp[row-1][triangle[row-1].length - 1] + triangle[row][col];
                else
                    dp[row][col] = Math.max(dp[row-1][col-1] + triangle[row][col], dp[row-1][col] + triangle[row][col]);
            }
        }

        int max = 0;
        for (int i = 0; i < triangle.length; i++)
            max = Math.max(max, dp[triangle.length-1][i]);

        return max;
    }
}

