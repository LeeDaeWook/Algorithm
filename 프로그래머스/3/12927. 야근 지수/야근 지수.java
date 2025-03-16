import java.util.*;
import java.lang.Math;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        
        for (Integer work: works) {
            q.offer(work);
            answer += (long) work * work;
        }
        
        while (n-- > 0) {
            Integer num = q.poll();
            if (num <= 0)
                break;
            answer += -2*num + 1;
            q.offer(num-1);
        }
        
        return answer;
    }
}