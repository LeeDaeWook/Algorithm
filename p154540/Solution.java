package programmers.p154540;

import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();

        Queue<Pair> q = new ArrayDeque<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) == 'X'|| visited[i][j] == true) {
                    continue;
                }
                int food = 0;
                food += Integer.parseInt(String.valueOf(maps[i].charAt(j)));
                q.add(new Pair(j, i));
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    Pair pos = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int x = pos.x + dx[k];
                        int y = pos.y + dy[k];
                        if (x < 0 || x >= maps[i].length() || y < 0 || y >= maps.length)
                            continue;
                        if (maps[y].charAt(x) != 'X' && visited[y][x] == false) {
                            q.add(new Pair(x, y));
                            visited[y][x] = true;
                            food += Integer.parseInt(String.valueOf(maps[y].charAt(x)));
                        }
                    }
                }
                answer.add(food);
            }
        }
        if (answer.isEmpty())
            answer.add(-1);
        return answer.stream().sorted().mapToInt(e -> e).toArray();
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}