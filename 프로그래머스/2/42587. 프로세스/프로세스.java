import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        Deque<Integer> stack = new ArrayDeque<>();
        
        while (true) {
            if (stack.size() == len) // 반복문 탈출 조건
                break;
            for (int i = 0; i < len; i++) {
                if (priorities[i] == 0) // 이미 stack에 넣은 프로세스인 경우
                    continue;
                for (int j = 0; j < len; j++) {
                    if (priorities[i] < priorities[j])
                        // priorities[i]에 있는 프로세스보다 우선순위가 더 높은 프로세스가 있는 경우
                        break;
                    if (j == len - 1) {
                        // priorities[i]의 프로세스가 가장 높은 우선순위인 경우
                        stack.push(i);
                        priorities[i] = 0; // priorities 배열에서 제거했다는 의미
                    }
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (location == stack.pollLast()) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}