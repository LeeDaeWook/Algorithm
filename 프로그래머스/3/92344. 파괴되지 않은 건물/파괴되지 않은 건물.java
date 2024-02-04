import java.util.*;

class Solution {
    int[][] sum;
        
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        sum = new int[board.length+1][board[0].length+1];
        
        for (int i = 0; i < skill.length; i++) {
            int degree = skill[i][0] == 1 ? -1 * skill[i][5] : skill[i][5];            
            apply(skill[i][1], skill[i][2], skill[i][3], skill[i][4], degree);
        }

        // 위에서 아래로 누적합 계산
        for (int i = 0; i < sum[0].length; i++) {
            for (int j = 1; j < sum.length; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
        // 왼쪽에서 오른쪽으로 누적합 계산
        for (int i = 0; i < sum.length; i++) {
            for (int j = 1; j < sum[i].length; j++) {
                sum[i][j] += sum[i][j-1];
            }
        }
        
        // board 배열에 sum 배열 적용
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int result = board[i][j] + sum[i][j];
                if (result > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void apply(int startX, int startY, int endX, int endY, int degree) {
        sum[startX][startY] += degree;
        sum[startX][endY+1] += -1 * degree;
        sum[endX+1][startY] += -1 * degree;
        sum[endX+1][endY+1] += degree;
    }    
    
}