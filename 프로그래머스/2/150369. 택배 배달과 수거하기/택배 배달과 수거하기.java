class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverIdx = -1;
        int pickupIdx = -1;
        
        for (int i = n-1; i >= 0; i--) {
            if (deliveries[i] > 0) {
                deliverIdx = i;
                break;                
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (pickups[i] > 0) {
                pickupIdx = i; 
                break;
            }
        }
        
        while (true) {
            answer += deliverIdx > pickupIdx ? (deliverIdx+1) * 2 : (pickupIdx+1) * 2;
            deliverIdx = work(deliveries, deliverIdx, cap);
            pickupIdx = work(pickups, pickupIdx, cap);
            if (deliverIdx == -1 && pickupIdx == -1)
                break;
        }
        
        return answer;
    }
    
    public int work(int[] boxes, int start, int cap) {
        for (int i = start; i >= 0; i--) {
            int residual = cap - boxes[i];
            if (residual >= 0) {
                cap -= boxes[i];
                boxes[i] = 0;
            }
            else {
                cap -= boxes[i] + residual;
                boxes[i] = residual * -1;
                return i;
            }
        }
        
        return -1;
    }
}