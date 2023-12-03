package programmers.p118667;

import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = addElementToqueue(queue1);
        Queue<Integer> q2 = addElementToqueue(queue2);

        long sum1 = calculateSum(q1);
        long sum2 = calculateSum(q2);
        int originSize = q1.size();
        int sizeOne = q1.size();
        int sizeTwo = q2.size();
        if ((sum1 + sum2) % 2 != 0)
            return -1;
        while (true) {
            if (sum1 == sum2)
                break;

            if (sum1 > sum2) {
                int temp = q1.poll();
                sum1 -= temp;
                sum2 += temp;
                sizeOne--;
                sizeTwo++;
                q2.add(temp);
            }
            else if (sum1 < sum2) {
                int temp = q2.poll();
                sum1 += temp;
                sum2 -= temp;
                sizeOne++;
                sizeTwo--;
                q1.add(temp);
            }
            answer++;

            if (sizeOne == 0 || sizeTwo == 0)
                return -1;
            if (answer > originSize * 4)
                return -1;
        }

        return answer;
    }

    private Queue<Integer> addElementToqueue(int[] queue) {
        Queue<Integer> q = new LinkedList<>();

        for (int e : queue) {
            q.add(e);
        }
        return q;
    }

    private long calculateSum(Queue<Integer> q) {
        long sum = 0;
        for (Integer e : q) {
            sum += e;
        }

        return sum;
    }
}