package programmers.p161988;

import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;

        long[] plusSum = new long[sequence.length];
        long[] minusSum = new long[sequence.length];

        // 초기값 설정
        plusSum[0] = sequence[0];
        minusSum[0] = -1 * sequence[0];
        answer = Math.max(plusSum[0], minusSum[0]);

        for (int i = 1; i < sequence.length; i++) {
            plusSum[i] = Math.max(sequence[i], minusSum[i - 1] + sequence[i]);
            minusSum[i] = Math.max(-1 * sequence[i], plusSum[i - 1] - sequence[i]);
            answer = Math.max(answer, Math.max(plusSum[i], minusSum[i]));
        }

        return answer;
    }
}
