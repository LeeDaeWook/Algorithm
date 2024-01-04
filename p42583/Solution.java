package programmers.p42583;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Deque<Integer> weightQ = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) {
            weightQ.add(truck_weights[i]);
        }
        Deque<Integer> movingQ = new ArrayDeque<>();

        int curWeight = 0;
        while (true) {
            if (movingQ.size() == bridge_length)
                curWeight -= movingQ.poll();

            if (!weightQ.isEmpty() && curWeight + weightQ.peek() <= weight) {
                curWeight += weightQ.peek();
                movingQ.add(weightQ.poll());
            }
            else
                movingQ.add(0);

            if (weightQ.isEmpty()) {
                answer += bridge_length;
                break;
            }

            answer++;
        }

        return answer + 1;
    }
}