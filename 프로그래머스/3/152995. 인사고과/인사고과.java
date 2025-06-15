import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int topScore = -1;
        BitSet removed = new BitSet(scores.length);
        int[] scoresOfWanho = new int[]{scores[0][0], scores[0][1]};
        int sumOfWanho = scoresOfWanho[0] + scoresOfWanho[1];
                
        // scores 정렬 -> 근무태도점수 내림차순 & 동료평가점수 오름차순 기준 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] != b[0])
                return b[0] - a[0];
            else
                return a[1] - b[1];
        });
        
        // 인센티브 못 받는 사원 체크
        for (int i = 0; i < scores.length-1; i++) {
            if (scores[i][1] > topScore)
                topScore = scores[i][1];
            else if (scores[i][1] < topScore) {
                removed.set(i);
                // 완호가 인센티브 못 받는 경우
                if (scores[i][0] == scoresOfWanho[0] && scores[i][1] == scoresOfWanho[1])
                    return -1;
            }
        }
        
        // 완호의 석차 계산
        for (int i = 0; i < scores.length; i++) {
            if (removed.get(i))
                continue;
            
            if (scores[i][0] + scores[i][1] > sumOfWanho)
                answer++;
        }
        
        return answer;
    }
}