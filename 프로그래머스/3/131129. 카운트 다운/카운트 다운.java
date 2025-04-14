class Solution {
    int[] dartTable = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,24,26,27,28,30,32,33,34,36,38,39,40,42,45,48,50,51,54,57,60};
    
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[][] memo = new int[target+1][2];    
        
        for (int i = 1; i <= target; i++)
            memo[i][0] = 2000;
        
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < 42; j++) {
                if (i - dartTable[j] >= 0) {
                    int darts = memo[i-dartTable[j]][0] + 1;
                    int singleOrBull = memo[i-dartTable[j]][1];
                    if (dartTable[j] <= 20 || dartTable[j] == 50)
                        singleOrBull++;

                    if (darts < memo[i][0]) {
                        memo[i][0] = darts;
                        memo[i][1] = singleOrBull;
                    }
                    else if (darts == memo[i][0] && singleOrBull > memo[i][1])
                        memo[i][1] = singleOrBull;
                }
            }
        }
        
        answer[0] = memo[target][0];
        answer[1] = memo[target][1];
        
        return answer;
    }
}