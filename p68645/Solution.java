package programmers.p68645;

import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n];

        int[][] snail = new int[n][n];
        int[] startNum = new int[]{1};
        int[] rootPos = new int[2];

        dfs(n, snail, rootPos, startNum, 0, n);

        return Arrays.stream(snail).flatMapToInt(Arrays::stream).filter(e -> e> 0).toArray();
    }

    private void dfs(int n, int[][] snail, int[] rootPos, int[] startNum, int minus, int size) {
        if (size <= 0) {
            return ;
        }
        fillLeft(rootPos[0], n, rootPos[1], snail, startNum);
        fillBottom(rootPos[1], n, n - 1, snail, startNum);
        fillRight(n - 1, rootPos[0], minus, snail, startNum);
        rootPos[0] += 2;
        rootPos[1] += 1;
        dfs(n - 1, snail, rootPos, startNum, minus + 1, n - 3);
    }

    private void fillLeft(int startRow, int endRow, int col, int[][] snail, int[] startNum) {
        for (int i = startRow; i < endRow; i++) {
//            if (snail[i][col] == 0)
                snail[i][col] = (startNum[0])++;
        }
    }
    // 2, 7, 1, snail, startNum

    private void fillBottom(int startCol, int endCol, int row, int[][] snail, int[] startNum) {
        for (int i = startCol; i < endCol; i++) {
            if (snail[row][i] == 0)
                snail[row][i] = (startNum[0])++;
        }
    }
    // 1, 7, 6, snail, startNum

    private void fillRight(int start, int end, int minus, int[][] snail, int[] startNum) {
        for (int i = start; i > end; i--) {
            if (snail[i][i-minus] == 0)
                snail[i][i-minus] = (startNum[0])++;
        }
    }
    // 6, 2, snail, startNum
}

// n - (n - 2)
// 3n - 3
