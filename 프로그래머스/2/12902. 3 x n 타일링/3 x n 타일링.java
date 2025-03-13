class Solution {
    long[] memo;
    long MOD = 1000000007;
    
    public int solution(int n) {
        if (n % 2 == 1)
            return 0;
        
        memo = new long[n+1];
        memo[0] = 1;
        memo[2] = 3;
        
        return (int) search(n);
    }
    
    public long search(int depth) {
        if (memo[depth] != 0 || depth <= 2)
            return memo[depth];
        
        for (int i = depth; i >= 2; i-=2) {
            int mult = i == 2 ? 3 : 2;
            memo[depth] = (memo[depth] + mult * search(depth-i)) % MOD;
        }
                
        return memo[depth];
    }
}