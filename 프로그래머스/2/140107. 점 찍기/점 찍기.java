import java.util.*;
import java.lang.Math;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i * k <= d; i++) {
            long residualDist = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i*k, 2));
            answer += residualDist / k + 1;
        }
        
        return answer;
    }
}