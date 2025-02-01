import java.util.*;
import java.lang.Math;

class Solution {
    int answer = 0;
    boolean[] column;
    boolean[] diagonal1;
    boolean[] diagonal2;

    public int solution(int n) {
        column = new boolean[n];
        diagonal1 = new boolean[n * 2 - 1];
        diagonal2 = new boolean[n * 2 - 1];
        recursive(0, n);
        return answer;
    }
    
    public void recursive(int row, int n) {
        // 체스판의 끝까지 왔으면
        if (row == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 열, 대각선(/방향), 대각선(\방향) 검사
            if (column[i] || diagonal1[row + i] || diagonal2[row - i + n - 1])
                continue;
            column[i] = diagonal1[row+i] = diagonal2[row - i + n - 1] = true;
            recursive(row+1, n);
            column[i] = diagonal1[row+i] = diagonal2[row - i + n - 1] = false;
        }
    }
}