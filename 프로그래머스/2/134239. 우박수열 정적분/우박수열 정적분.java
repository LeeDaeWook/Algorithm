import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        double[] sumSeries = new double[100000];
        int idx = 1;
        sumSeries[idx] = (double)k;
        
        // 우박수열의 누적합 계산
        while(k > 1) {
            if (k % 2 == 0)
                k = k / 2;
            else 
                k = k * 3 + 1;
            sumSeries[++idx] = sumSeries[idx - 1] + (double)k;
        }
        
        int n = idx - 1;
        for (int i = idx+1; i < 100000; i++)
            sumSeries[i] = sumSeries[idx];
        
        // 각 구간 [a, b]에 대해 정적분 값 계산
        for (int i = 0; i < ranges.length; i++) {
            int a = ranges[i][0] + 1;
            int b = n + ranges[i][1] + 1;
            if (a > b)
                answer[i] = -1.0;
            else
                answer[i] = (sumSeries[b-1] - sumSeries[a-1] + sumSeries[b] - sumSeries[a]) / 2.0;
            // if (answer[i] < 0)
            //     answer[i] = -1.0;
        }
        
        return answer;
    }
}