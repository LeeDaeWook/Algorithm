import java.lang.Math.*;
import java.util.*;

class Solution {
    int answer = 120;
    int[][] check;
    
    public int solution(int[][] info, int n, int m) {
        check = new int[n+1][info.length];

        for (int i = 0; i < check.length; i++)
            Arrays.fill(check[i], -1);
        
        dfs(0, 0, 0, n, m, info);
        
        return answer != 120 ? answer : -1;
    }
    
    public void dfs(int idx, int traceA, int traceB, int n, int m, int[][] info) {
        if (traceA >= answer || traceA >= n || traceB >= m)
            return;            
        if (idx == info.length) {
            if (traceA < n && traceB < m)
                answer = Math.min(answer, traceA);
            return ;
        }        
        if (check[traceA][idx] == traceB)
            return;            

        dfs(idx+1, traceA, traceB + info[idx][1], n, m, info);
        dfs(idx+1, traceA + info[idx][0], traceB, n, m, info);
        
        check[traceA][idx] = traceB;
    }
}