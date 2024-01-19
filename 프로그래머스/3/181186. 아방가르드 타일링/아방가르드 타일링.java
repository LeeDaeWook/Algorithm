import java.util.*;

class Solution {
    int mod = 1000000007;
    
    public int solution(int n) {
        long[] dp = new long[n+1];
        long[] four = new long[n+1];
        long[] five = new long[n+1];
        long[] six = new long[n+1];
        
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0)
                dp[i] = (dp[i] + dp[i-1] * 1) % mod;
            if (i - 2 >= 0)
                dp[i] = (dp[i] + dp[i-2] * 2) % mod;
            if (i - 3 >= 0)
                dp[i] = (dp[i] + dp[i-3] * 5) % mod;
            if (i - 4 >= 0) {
                four[i] = (four[i-3] + dp[i-4] * 2) % mod;
                dp[i] = (dp[i] + four[i]) % mod;
            }
            if (i - 5 >= 0) {
                five[i] = (five[i-3] + dp[i-5] * 2) % mod;
                dp[i] = (dp[i] + five[i]) % mod;
            }
            if (i - 6 >= 0) {
                six[i] = (six[i-3] + dp[i-6] * 4) % mod;
                dp[i] = (dp[i] + six[i]) % mod;
            }
        }
        
        return (int) dp[n] % mod;
    }
}