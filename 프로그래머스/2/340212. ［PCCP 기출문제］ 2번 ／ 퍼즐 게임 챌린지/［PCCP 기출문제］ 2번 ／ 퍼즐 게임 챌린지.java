class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int maxDiff = 0;
        long totalSum = 0;
                
        for (int i = 0; i < times.length; i++) {
            totalSum += times[i];
            if (diffs[i] > maxDiff)
                maxDiff = diffs[i];
        }
        
        long[] addedSumByDiff = new long[maxDiff+1];
        long[] cumulativeSumByDiff = new long[maxDiff+1];
        long[] totalSumByLevel = new long[maxDiff+1];
        
        addedSumByDiff[diffs[0]] += times[0];
        // 각 난이도별로 퍼즐들을 한번씩 틀렸을 때 추가되는 소요시간 계산
        for (int i = 1; i < diffs.length; i++)
            addedSumByDiff[diffs[i]] += times[i-1] + times[i];

        cumulativeSumByDiff[maxDiff] = addedSumByDiff[maxDiff];
        for (int i = maxDiff; i > 1; i--)
            cumulativeSumByDiff[i-1] = cumulativeSumByDiff[i] + addedSumByDiff[i-1];
        
        totalSumByLevel[1] += totalSum;
        for (int i = 2; i <= maxDiff; i++)
            totalSumByLevel[1] += (i-1) * addedSumByDiff[i];        
        
        for (int i = 1; i < maxDiff; i++) {
            if (totalSumByLevel[i] <= limit)         
                return i;
            totalSumByLevel[i+1] = totalSumByLevel[i] - cumulativeSumByDiff[i+1];            
        }
        
        return maxDiff;
    }
}