package programmers.p43165;

import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int[] answer = new int[1];

        dfs(answer, 0, numbers, target, 0);

        return answer[0];
    }

    private void dfs(int[] answer, int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length) {
            if (sum == target)
                (answer[0])++;
            return ;
        }

        dfs(answer, depth + 1, numbers, target, sum + numbers[depth]);
        dfs(answer, depth + 1, numbers, target, sum - numbers[depth]);
    }
}
