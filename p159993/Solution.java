package programmers.p159993;

import java.util.*;
class Solution {
    int[] dirX = {0, 1, 0, -1};
    int[] dirY = {-1, 0, 1, 0};
    boolean[][] visited = new boolean[100][100];
    int answer = 0;
    Queue<Pair> q = new ArrayDeque<>();
    boolean isExit = true;

    public int solution(String[] maps) {

        q.add(findPos(maps, 'S', 0));
        bfs(maps, 'L');

        for (int i = 0; i < maps.length; i++)
            Arrays.fill(visited[i], false);

        q.clear();
        q.add(findPos(maps, 'L', 0));
        bfs(maps, 'E');

        if (isExit == false)
            return -1;
        return answer;
    }

    private void bfs(String[] maps, char find) {
        while (!q.isEmpty()) {
            Pair position = q.poll();
            visited[position.row][position.col] = true;
            int row = position.row;
            int col = position.col;
            int distance = position.distance;
            for (int i = 0; i < 4; i++) {
                if (row + dirY[i] < 0 || row + dirY[i] >= maps.length || col + dirX[i] < 0 || col + dirX[i] >= maps[row].length()
                        || maps[row + dirY[i]].charAt(col + dirX[i]) == 'X')
                    continue;

                if (visited[row + dirY[i]][col + dirX[i]] == true)
                    continue;

                Pair temp = new Pair(row + dirY[i], col + dirX[i], distance + 1);
                q.add(temp);
                visited[row + dirY[i]][col + dirX[i]] = true;

                if (maps[row + dirY[i]].charAt(col + dirX[i]) == find) {
                    answer += distance + 1;
                    return ;
                }
            }
        }

        isExit = false;
    }

    private Pair findPos(String[] maps, char find, int distance) {
        for (int row = 0; row < maps.length; row++) {
            for (int col = 0; col < maps[row].length(); col++) {
                if (maps[row].charAt(col) == find)
                    return new Pair(row, col, distance);
            }
        }
        return null;
    }
}

class Pair {
    int row;
    int col;
    int distance;

    public Pair(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}