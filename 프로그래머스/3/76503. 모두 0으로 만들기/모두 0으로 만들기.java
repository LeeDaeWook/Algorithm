import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        // a의 모든 원소의 합 != 0 이면 모든 노드를 0으로 만들 수 없다.
        long sum = 0;
        for (int num: a)
            sum += num;
        if (sum != 0)
            return -1;
        
        long answer = 0;
        Map<Integer, List<Integer>> adjacentList = new HashMap<>();
        long[] b = new long[a.length];
        BitSet used = new BitSet(a.length);
        Stack<int[]> stack = new Stack<>();
        Stack<int[]> temp = new Stack<>();
        
        for (int i = 0; i < a.length; i++) 
            b[i] = a[i];
        
        // 인접 리스트 초기화
        for (int[] edge: edges) {
            adjacentList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adjacentList.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // 루트 노트부터 시작해서 트리의 모든 노드들을 스택에 담는다. -> 스택의 맨 위 노드가 말단 노드들
        stack.push(new int[]{0, 0});
        temp.push(new int[]{0, 0});
        used.set(0);
        while (!temp.isEmpty()) {
            int[] e = temp.pop();
            int child = e[0];
            int parent = e[1];
            
            for (int grandchild: adjacentList.get(child)) {
                if (!used.get(grandchild)) {
                    used.set(grandchild);
                    stack.push(new int[]{grandchild, child});
                    temp.push(new int[]{grandchild, child});
                }
            }
        }
        
        // 연산 수행
        while (!stack.isEmpty()) {
            int[] e = stack.pop();
            int child = e[0];
            int parent = e[1];

            // 현재 노드의 값을 0으로 만들기 위한 연산 수행
            b[parent] += b[child];
            answer += Math.abs(b[child]);
        }
                
        return answer;
    }
}