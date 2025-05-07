class Solution {
    int answer = 0;
    boolean[] used;
    
    public int solution(int n, int[][] q, int[] ans) {
        used = new boolean[n+1];
        dfs(0, 1, n, q, ans);
        return answer;
    }
    
    public void dfs(int depth, int start, int n, int[][] q, int[] ans) {
        if (depth == 5) {
            // 검증
            if (isValid(q, ans))
                answer++;                
            return;
        }
        
        for (int i = start; i <= n; i++) {
            used[i] = true;
            dfs(depth+1, i+1, n, q, ans);
            used[i] = false;
        }
    }
    
    public boolean isValid(int[][] q, int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (used[q[i][j]])
                    count++;
            }
            if (count != ans[i])
                return false;
        }
        return true;
    }
}