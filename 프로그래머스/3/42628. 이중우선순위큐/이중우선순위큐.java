import java.util.*;

class Solution {
    Map<Integer, Integer> count = new HashMap<>();

    public int[] solution(String[] operations) {
        int len = operations.length;
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < len; i++) {
            String[] op = operations[i].split(" ");
            switch (op[0]) {
                case "I":
                    int num = Integer.valueOf(op[1]);
                    maxQ.offer(num);
                    minQ.offer(num);
                    count.put(num, count.getOrDefault(num, 0) + 1);
                    break;
                case "D":
                    if (op[1].equals("1"))
                        delete(maxQ);
                    else
                        delete(minQ);
                    break;
            }
        }
                
        return new int[] {find(maxQ), find(minQ)};        
    }
    
    public void delete(PriorityQueue<Integer> q) {
        while (!q.isEmpty()) {
            int num = q.poll();
            if (count.get(num) > 0) {
                count.put(num, count.get(num) - 1);
                return ;
            }
        }
    }
    
    public int find(PriorityQueue<Integer> q) {
        while (!q.isEmpty()) {  
            int num = q.poll();
            if (count.get(num) > 0)
                return num;
        }
        return 0;
    }
    
}