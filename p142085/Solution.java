package programmers.p142085;

import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int e : enemy) {
            if (k > 0) {
                q.add(e);
                k--;
            }
            else if (e > q.peek()) {
                n -= q.poll();
                q.add(e);
            }
            else
                n -= e;

            if (n < 0)
                break;
            answer++;
        }

        return answer;
    }
}
