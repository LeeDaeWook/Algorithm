package programmers.p87946;

import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int[] answer = new int[1];
        List<Integer> visited = new ArrayList<>();

        dfs(k, dungeons, 0, answer, visited);
        return answer[0];
    }

    private void dfs(int k, int[][] dungeons, int depth, int[] answer, List<Integer> visited) {
        if (depth == dungeons.length) {
            answer[0] = depth;
            return ;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if ((!visited.isEmpty() && visited.contains(i)) || k < dungeons[i][0])
                continue;
            visited.add(i);
            dfs(k - dungeons[i][1], dungeons, depth + 1, answer, visited);
            visited.remove(visited.indexOf(i));
        }

        answer[0] = Math.max(answer[0], depth);
    }
}
