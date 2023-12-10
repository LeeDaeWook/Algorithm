package baekjoon.b10835;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    static int[] leftDummy;
    static int[] rightDummy;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        StringTokenizer left = new StringTokenizer(bf.readLine());
        StringTokenizer right = new StringTokenizer(bf.readLine());

        leftDummy = new int[n];
        rightDummy = new int[n];
        for (int i = 0; i < n; i++) {
            leftDummy[i] = Integer.parseInt(left.nextToken());
            rightDummy[i] = Integer.parseInt(right.nextToken());
        }

        dp = new int[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        int result = recursion(0, 0);
        System.out.println(result);
    }

    private static int recursion(int l, int r) {
        if (l == n || r == n) {
            return 0;
        }

        if (dp[l][r] != -1)
            return dp[l][r];

        dp[l][r] = Math.max(recursion(l + 1, r + 1), recursion(l + 1, r));

        if (leftDummy[l] > rightDummy[r])
            dp[l][r] = Math.max(dp[l][r], recursion(l, r + 1) + rightDummy[r]);

        return dp[l][r];
    }
}
