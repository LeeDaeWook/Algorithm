import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> numbers = new ArrayList<>();
        long[] factorial = new long[n];
        
        // 1~n까지 삽입
        for (int i = 1; i <= n; i++)
            numbers.add(i);
        
        factorial[0] = 1;
        // 1! ~ (n-1)! 까지 삽입    
        for (int i = 1; i < n; i++)
            factorial[i] = factorial[i-1] * i;
        
        for (int i = 0; i < n - 1; i++) {
            if (i > 0) {
                k = k % factorial[n-i];
                if (k == 0)
                    k = factorial[n-i];
            }
            int idx = (int) (k / factorial[n-i-1]) - 1;
            // 나머지가 있으면
            if (k % factorial[n-i-1] > 0)
                idx++;
            answer[i] = numbers.get(idx);
            numbers.remove(idx);
        }
        answer[n-1] = numbers.get(0);
        
        return answer;
    }
}