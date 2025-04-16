import java.util.*;

class Solution {
    static final int DOHNUT = 1;
    static final int BAR = 2;
    static final int EIGHT = 3;
    Set<Integer> nodes = new HashSet<>();
    
    
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        
        // 인접리스트 초기화
        for (int i = 0; i < edges.length; i++) {
            if (adjList.get(edges[i][0]) == null)
                adjList.put(edges[i][0], new ArrayList<>());
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        
        int newNode = findNewNode(adjList);
        answer[0] = newNode;
        
        for (int startNode: adjList.get(newNode)) {
            putNodes(startNode, adjList);
            switch(decideGraph(adjList)) {
                case DOHNUT -> answer[DOHNUT]++;
                case BAR -> answer[BAR]++;                    
                case EIGHT -> answer[EIGHT]++;
            }
            nodes.clear();
        }
        
        return answer;
    }
    
    public void putNodes(int node, Map<Integer, List<Integer>> adjList) {
        if (nodes.contains(node))
            return ;
        nodes.add(node);
        
        for (int n: adjList.getOrDefault(node, Collections.emptyList()))
            putNodes(n, adjList);                
    }
    
    public int decideGraph(Map<Integer, List<Integer>> adjList) {
        for (int node: nodes) {
            List<Integer> values = adjList.getOrDefault(node, Collections.emptyList());
            if (values.isEmpty())
                return BAR;
            else if (values.size() == 2)
                return EIGHT;
        }
        return DOHNUT;
    }
    
    public int findNewNode(Map<Integer, List<Integer>> adjList) {
        Set<Integer> keys = new HashSet<>(adjList.keySet());
        Set<Integer> values = new HashSet<>();
        
        for (List<Integer> valueList: adjList.values())
            values.addAll(valueList);
        
        keys.removeAll(values);
        
        for (int key: keys) {
            if (adjList.get(key) != null && adjList.get(key).size() >= 2)
                return key;
        }
                                
        return 0;
    }
}