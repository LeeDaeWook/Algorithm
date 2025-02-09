import java.util.*;

class Solution {
    long[] memo;
    
    public int solution(int n) {
        memo = new long[n+1];
        memo[0] = 1;
        memo[1] = 1;
        
        return (int) search(n);
    }
    
    public long search(int depth) {
        if (memo[depth] != 0 || depth <= 1)
            return memo[depth];
        
        memo[depth] += search(depth-1) + search(depth-2);
        
        return memo[depth] % 1000000007;
    }
}