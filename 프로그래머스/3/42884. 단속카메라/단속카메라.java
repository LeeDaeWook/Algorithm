import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, Comparator.comparingInt(arr -> arr[0]));
        
        int max = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (max < routes[i][0]) {
                max = routes[i][1];
                answer++;
            }
            if (max > routes[i][1])
                max = routes[i][1];
            // System.out.println(routes[i][0]);
        }
        
        return answer;
    }
}