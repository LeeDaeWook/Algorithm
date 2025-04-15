class Solution {
    public int solution(int n) {
        int answer = 0;
        int l = 1;
        int sum = 0;
        
        for (int r = 1; r <= n/2+1; r++) {
            if (sum < n)
                sum += r;
            while (sum >= n) {
                if (sum == n)
                    answer++;                    
                sum -= l++;
            }                            
        }
        if (n == 1 || n == 2)
            answer--;
        
        return answer+1;
    }
}