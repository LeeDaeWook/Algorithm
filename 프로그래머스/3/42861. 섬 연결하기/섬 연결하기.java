import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // parent 배열 초기화
        parent = new int[n+1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        
        // 거리 기준으로 costs 정렬
        Arrays.sort(costs, (e1, e2) -> e1[2] - e2[2]);
        
        for (int i = 0; i < costs.length; i++) {
            if (!find(costs[i][0], costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }

        return answer;
    }
    
    private void union(int x, int y) {
        int a = getParent(x);
        int b = getParent(y);
        if (a < b) 
            parent[b] = a;
        else
            parent[a] = b;
    }
    
    private boolean find(int x, int y) {
        return getParent(x) == getParent(y);
    }
    
    private int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }
}