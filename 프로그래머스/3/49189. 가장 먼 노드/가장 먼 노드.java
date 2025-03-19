import java.util.*;

class Solution {
    int INF = 2147483647;
    
    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        int[] distance = new int[n+1];
        
        // 인접리스트 & distance 배열 초기화
        for (int i = 1; i <= n; i++)
            adjList.put(i, new ArrayList<>());
        
        for (int i = 2; i <= n; i++)
            distance[i] = INF;
        
        for (int i = 0; i < edge.length; i++) {
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }
        
        // 1번 노드에서 각 노드까지의 최단경로 찾기 (다익스트라)
        q.offer(1);
        while (!q.isEmpty()) {
            int startNode = q.poll();
            List<Integer> nodes = adjList.get(startNode);
            for (int node: nodes) {
                if (distance[startNode] + 1 < distance[node]) {
                    distance[node] = distance[startNode] + 1;
                    q.offer(node);
                }
            }
        }
        
        int max = Arrays.stream(distance).max().getAsInt();
        return (int) Arrays.stream(distance).filter(x -> x == max).count();
    }
}