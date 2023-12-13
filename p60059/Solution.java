package programmers.p60059;

import java.util.*;
class Solution {
    boolean answer = false;

    public boolean solution(int[][] key, int[][] lock) {

        int[] move = new int[4];
        dfs(0, key, lock, 0, move);

        return answer;
    }

    private void dfs(int depth, int[][] key, int[][] lock, int rotate, int[] move) {
        if (depth == 5) {
            int[] startPos = moveKey(move);
            if (isOpen(merge(key, lock, startPos)))
                answer = true;
            return ;
        }

        // 회전
        if (depth == 0) {
            for (int i = 0; i < 4; i++) {
                key = rotateKey(key, i);
                dfs(depth + 1, key, lock, rotate + i, move);
            }
        }

        // 이동 (순서 : 위 -> 오른쪽 -> 아래 -> 왼쪽)
        if (depth > 0) {
            for (int i = 0; i < lock.length; i++) {
                move[depth - 1] = i;
                dfs(depth + 1, key, lock, rotate, move);
            }
        }
    }

    private int[][] merge(int[][] key, int[][] lock, int[] startPos) {
        int[][] newLock = new int[lock.length][lock.length];
        for (int i = 0; i < lock.length; i++)
            newLock[i] = Arrays.copyOf(lock[i], lock.length);

        for (int row = startPos[0]; row < lock.length; row++) {
            for (int col = startPos[1]; col < lock.length; col++) {
                if (row < 0 || col < 0 || row - startPos[0] >= key.length || col - startPos[1] >= key.length)
                    continue;
                newLock[row][col] += key[row - startPos[0]][col - startPos[1]];
            }
        }

        return newLock;
    }

    private boolean isOpen(int[][] merge) {
        for (int row = 0; row < merge.length; row++) {
            for (int col = 0; col < merge.length; col++) {
                if (merge[row][col] != 1)
                    return false;
            }
        }
        return true;
    }

    private int[][] rotateKey(int[][] key, int rotate) {
        int[][] newKey = new int[key.length][key.length];
        if (rotate > 0) {
            for (int row = 0; row < key.length; row++) {
                for (int col = 0; col < key.length; col++)
                    newKey[row][col] = key[key.length - 1 - col][row];
            }
            return newKey;
        }
        return key;
    }

    private int[] moveKey(int[] move) {
        int[] startPos = new int[2];
        startPos[0] -= move[0];
        startPos[0] += move[2];
        startPos[1] += move[1];
        startPos[1] -= move[3];

        return startPos;
    }
}

// 회전 : 90도, 180도, 270도
// 이동 : 위, 아래, 오른쪽, 왼쪽 0 ~ (n - 1)칸