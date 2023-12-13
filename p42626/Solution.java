package programmers.p42626;

import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> q = new PriorityQueue<>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));
        int scoville1;
        int scoville2;
        while (true) {
            if (!q.isEmpty() && q.peek() < K) {
                scoville1 = q.poll();
                if (!q.isEmpty())
                    scoville2 = q.poll();
                else
                    return -1;
                q.add(scoville1 + scoville2 * 2);
            }
            else
                break;
            answer++;
        }
        return answer;
    }
}
