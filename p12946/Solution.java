package programmers.p12946;

import java.util.*;

class Solution {
    int[][] answer;
    int row = 0;

    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n) - 1][2];
        recursion(n, 1, 3, 2);
        return answer;
    }

    private void recursion(int n, int from, int to, int via) {
        if (n == 1) {
            move(from, to);
            return ;
        }
        recursion(n-1, from, via, to);
        move(from, to);
        recursion(n-1, via, to, from);
    }

    private void move(int from, int to) {
        answer[row][0] = from;
        answer[row++][1] = to;
    }
}
