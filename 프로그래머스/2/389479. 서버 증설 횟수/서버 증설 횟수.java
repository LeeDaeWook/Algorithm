import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        // 각 시간대에 증설한 서버수 저장
        int[] serversAdded = new int[24];
        // 현재 실행중인 서버 수
        int serverNum = 0;
        int answer = 0;
        
        for (int i = 0; i < 24; i++) {
            // 서버 수명 체크
            if (i - k >= 0)
                serverNum -= serversAdded[i-k];
            
            serversAdded[i] = Math.max(players[i] / m - serverNum, 0);
            serverNum += serversAdded[i];
            answer += serversAdded[i];
        }
                
        return answer;
    }
}