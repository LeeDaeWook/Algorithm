import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[][] dp = new int[land.length][4];
        
        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = land[i][j] + findMax(j, dp[i-1]);
            }
        }
        

        return Arrays.stream(dp[land.length-1]).max().getAsInt();
    }

    // exclusiveNum을 제외한 가장 큰 수를 반환
    private int findMax(int exclusiveIdx, int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != exclusiveIdx && arr[i] > result) {
                result = arr[i];
            }
        }
        return result;
    }
}