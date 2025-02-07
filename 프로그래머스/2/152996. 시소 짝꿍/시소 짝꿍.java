class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        int[] originWeights = new int[1001];
        int[] counts = new int[4001];
        
        for (int w : weights) {
            originWeights[w]++;
            counts[w*2]++;
            counts[w*3]++;
            counts[w*4]++;
        }

        for (int w : weights) {
            // w*2일 때, *2, *3, *4
            counts[w*2]--;
            answer += counts[w*2];
            
            // w*3일 때, *2, *3, *4
            counts[w*3]--;
            answer += counts[w*3];
                            
            // w*4일 때, *2, *3, *4
            counts[w*4]--;
            answer += counts[w*4];
            
            // 원래 weight가 같은 사람들은 반복문에서 3번 계산되기 때문에 2번을 뺀다.
            if (originWeights[w] > 1) {
                originWeights[w]--;
                answer -= originWeights[w] * 2;
            }
        }
        
        return answer;  
    }
}