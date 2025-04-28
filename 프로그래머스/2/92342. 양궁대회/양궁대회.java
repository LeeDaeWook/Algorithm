import java.util.*;

class Solution {
    int[] answer;
    int[] arr = new int[11];
    int maxScoreDiff = 0;
    
    public int[] solution(int n, int[] info) {
        dfs(info, n, 10);
        if (maxScoreDiff == 0)
            return new int[]{-1};
        
        return answer;
    }
    
    public void dfs(int[] info, int n, int idx) {
        if (n < 0)
            return;
        if (n == 0 || (idx < 0 && n > 0)) {
            int scoreDiff = calculateScoreDiff(info);
            if (maxScoreDiff < scoreDiff) {
                maxScoreDiff = scoreDiff;
                answer = Arrays.copyOf(arr, arr.length);
                if (n > 0)
                    answer[10] += n;
            }
            return;
        }
            
        arr[idx] = info[idx]+1;
        dfs(info, n-(info[idx]+1), idx-1);
        arr[idx] = 0;
        dfs(info, n, idx-1);
    }
    
    public int calculateScoreDiff(int[] info) {
        int lionScore = 0;
        int apeachScore = 0;
        for (int i = 0; i <= 10; i++) {
            if (arr[i] == 0 && info[i] == 0)
                continue;
            if (arr[i] > info[i])
                lionScore += 10 - i;
            else
                apeachScore += 10 - i;
        }
        
        return lionScore - apeachScore;
    }
}