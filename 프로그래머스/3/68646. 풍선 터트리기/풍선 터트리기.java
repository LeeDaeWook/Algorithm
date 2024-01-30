import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        
        int min = Integer.MAX_VALUE;
        int minIdx = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
                minIdx = i;
            }
        }
            
        min = Integer.MAX_VALUE;
        for (int i = 0; i < minIdx; i++) {
            if (a[i] < min) {
                min = a[i];
                answer++;
            }
        }
        
        min = Integer.MAX_VALUE;
        for (int i = a.length-1; i > minIdx; i--) {
            if (a[i] < min) {
                min = a[i];
                answer++;
            }
        }
        
        return answer+1;
    }
}