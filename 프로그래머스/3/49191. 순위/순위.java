import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        Map<Integer, Set<Integer>[]> graph = new HashMap<>();
        Deque<Integer> q = new ArrayDeque<>();
        
        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            // 첫번째 set에는 i번째 노드한테 진 노드들, 두번째 set에는 i번째 노드한테 이긴 노드들
            graph.put(i, new HashSet[2]);
            for (int j = 0; j < 2; j++) {
                graph.get(i)[j] = new HashSet<>();
            }
        }
        
        // 그래프에 노드 삽입
        for (int i = 0; i < results.length; i++) {
            graph.get(results[i][0])[0].add(results[i][1]);
            graph.get(results[i][1])[1].add(results[i][0]);
        }
        
        for (int i = 1; i <= n; i++) {
            Set<Integer> nodeCount = new HashSet<>();
            
            // 현재 노드한테 진 노드들과 이긴 노드들 각각을 순회
            for (int j = 0; j < 2; j++) {
                for (int node: graph.get(i)[j]) {
                    q.offer(node);
                    nodeCount.add(node);
                }
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int adjNode: graph.get(node)[j]) {
                        if (nodeCount.contains(adjNode))
                            continue;
                        q.offer(adjNode);
                        nodeCount.add(adjNode);
                    }
                }
            }
            if (nodeCount.size() == n - 1)
                answer++;
            // nodeCount.clear();
        }
       
        return answer;
    }
}             