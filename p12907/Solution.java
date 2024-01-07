package programmers.p12907;

import java.util.*;

class Solution {
    long answer = 0;

    public int solution(int n, int[] money) {
        long[][] dp = new long[money.length + 1][n + 1];

        // 초기화
        for (int i = 0; i <= money.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= money.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= money[i-1])
                    dp[i][j] = dp[i-1][j] + dp[i][j - money[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return (int) dp[money.length][n] % 1000000007;
    }
}

