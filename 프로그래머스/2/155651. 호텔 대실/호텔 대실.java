import java.util.*;

class Solution {
    public int solution(String[][] book_time) {        
        int len = book_time.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[][] intTime = new int[len][2];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2; j++) {
                String[] time = book_time[i][j].split(":");
                intTime[i][j] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            }
        }
        
        Arrays.sort(intTime, (a, b) -> Integer.compare(a[0], b[0]));
        
        q.offer(intTime[0][1]);
        for (int i = 1; i < len; i++) {
            int startTime = intTime[i][0];
            if (q.peek() + 10 <= startTime)
                q.poll();
            q.add(intTime[i][1]);
        }
        
        return q.size();
    }
}