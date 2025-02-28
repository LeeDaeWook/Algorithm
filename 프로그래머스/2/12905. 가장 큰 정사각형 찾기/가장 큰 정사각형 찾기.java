import java.lang.Math.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int [][]board) {
        int answer = 0;
        int[][] sum = new int[board.length][board[0].length];
        
        // sum 배열 초기화
        for (int i = 0; i < board[0].length; i++)
            sum[0][i] = board[0][i];
        for (int i = 0; i < board.length; i++)
            sum[i][0] = board[i][0];
        
        if (IntStream.range(0, board.length).anyMatch(i -> (i < board[0].length && board[0][i] == 1) || board[i][0] == 1))
            answer = 1;
        
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    sum[i][j] = Math.min(Math.min(sum[i-1][j], sum[i][j-1]), sum[i-1][j-1]) + 1;
                    answer = (int) Math.max(answer, Math.pow(sum[i][j], 2));
                }
            }
        }
        
        return answer;
    }
}