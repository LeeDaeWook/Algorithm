import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<int[]> q = new ArrayDeque<>();
        // Vector<Integer> v = new Vector<>();
        int[] answer = new int[progresses.length];
        int idx = 0;
        
        for (int i = 0; i < progresses.length; i++)
            q.offerLast(new int[]{progresses[i], speeds[i]});
        
        while(q.size() > 0) {
            int gap = 100 - q.peekFirst()[0];
            int speed = q.peekFirst()[1];
            int workDay = divideAndRoundUp(gap, speed);
            
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] work = q.pollFirst();
                work[0] += workDay * work[1];
                q.offerLast(work);
            }
            
            int count = 0;
            for (int i = 0; i < qSize; i++) {
                if (q.peekFirst()[0] < 100) 
                    break;
                q.pollFirst();
                count++;
            }
            answer[idx++] = count;
            // v.add(count);
        }
        
        // int[] answer = new int[v.size()];
        // for (int i = 0; i < v.size(); i++) {
        //     answer[i] = v.get(i);
        // }
        
        // return answer;
        return Arrays.stream(answer).filter(i -> i!=0).toArray();
    }
    
    public int divideAndRoundUp(int dividend, int divisor) {
        return (dividend + divisor - 1) / divisor;
    }
}