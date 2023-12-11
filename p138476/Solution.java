package programmers.p138476;

import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        int[] size = new int[10000001];
        for (int i = 0; i < tangerine.length; i++)
            (size[tangerine[i]])++;

        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 1; i < size.length; i++) {
            if (size[i] != 0)
                q.add(size[i]);
        }

        while (k > 0) {
            k -= q.poll();
            answer++;
        }

        return answer;
    }
}