import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<int[]> q = new ArrayDeque<>();
        Vector<Integer> v = new Vector<>();
        
        // progresses에 있는 원소들 큐에 삽입
        for (int i = 0; i < progresses.length; i++)
            q.offerLast(new int[]{progresses[i], speeds[i]});
        
        while(q.size() > 0) {
            // 100 - 큐의 가장 앞에 있는 작업의 진도율 계산
            int gap = 100 - q.peekFirst()[0];
            int speed = q.peekFirst()[1];
            int workDay = divideAndRoundUp(gap, speed);
            
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] work = q.pollFirst();
                // 각 작업의 진도율 + gap * 각 작업의 작업속도 계산
                work[0] += workDay * work[1];
                q.offerLast(work);
            }
            
            int count = 0;
            // 진도율 >= 100인 작업들 count
            for (int i = 0; i < qSize; i++) {
                if (q.peekFirst()[0] < 100) 
                    break;
                q.pollFirst();
                count++;
            }
            v.add(count);
        }
        
        int[] answer = new int[v.size()];
        for (int i = 0; i < v.size(); i++) {
            answer[i] = v.get(i);
        }
        
        return answer;
    }
    
    public int divideAndRoundUp(int dividend, int divisor) {
        return (dividend + divisor - 1) / divisor;
    }
}