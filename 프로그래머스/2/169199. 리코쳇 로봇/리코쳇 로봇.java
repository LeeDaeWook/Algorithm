import java.util.*;
import java.lang.Math;

class Solution {
    int[] dx = {0, 0, -1, 1}; // 상,하,좌,우
    int[] dy = {-1, 1, 0, 0};
    int rows;
    int cols;
    boolean gFlag = false;
    boolean[][][] visited;
    
    public int solution(String[] board) {
        int answer = -1;
        rows = board.length;
        cols = board[0].length();
        Deque<int[]> q = new ArrayDeque<>();
        visited = new boolean[rows][cols][4];
        
        findStart(board, q);
        
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int[] newPos = move(board, pos[0]+dy[i], pos[1]+dx[i], i, pos[2]);                
                if (!visited[newPos[0]][newPos[1]][i]) {        
                    q.offer(new int[]{newPos[0], newPos[1], pos[2]+1});
                    visited[newPos[0]][newPos[1]][i] = true;                  
                }
                if (gFlag)
                    return newPos[2];
            }
        }
        
        return answer;
    }
    
    public int[] move(String[] board, int row, int col, int dir, int count) {
        while (isInBoard(row, col)) {
            if (board[row].charAt(col) == 'D')
                break;
            if (board[row].charAt(col) == 'G')
                gFlag = true;
            else
                gFlag = false;
            row += dy[dir];
            col += dx[dir];
        }
        return new int[]{row-dy[dir], col-dx[dir], count+1};
    }
    
    public void findStart(String[] board, Deque<int[]> q) {
        for (int row = 0; row < board.length; row++) {
            int col;
            if ((col = board[row].indexOf("R")) != -1) {
                q.offer(new int[]{row, col, 0});
                break;
            }
        }
    }
    
    public boolean isInBoard(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols)
            return true;
        return false;
    }
}