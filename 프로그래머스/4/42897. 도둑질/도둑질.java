import java.util.*;

class Solution {
    
    public int solution(int[] money) {
        int[] dp1 = new int[money.length-1];
        
        dp1[0] = money[0];
        for (int i = 1; i < money.length - 1; i++) {
            if (i == 1) {
                dp1[i] = money[i];
                continue;
            }
            if (i >= 3)
                dp1[i] = Math.max(dp1[i-3] + money[i], Math.max(dp1[i-2] + money[i], dp1[i-1]));
            else
                dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }
        
        int[] dp2 = new int[money.length];
        dp2[1] = money[1];
        for (int i = 2; i < money.length; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        
        return Math.max(dp1[money.length-2], dp2[money.length-1]);
    }
}