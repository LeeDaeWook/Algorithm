import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<>();
        int rows = grid.length;
        int cols = grid[0].length();
        BitSet[][] visited = new BitSet[rows][cols];
        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{-1, 0, 1, 0};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                visited[i][j] = new BitSet(4);
        }
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int k = 0; k < 4; k++) {
                    if (visited[row][col].get(k))
                        continue;
                    int direction = k;
                    int posX = col;
                    int posY = row;
                    int cycleLen = 0;
                    while (true) {
                        // 해당 위치에서 해당 방향으로 이미 지나간적이 있다면 여기까지의 경로가 사이클을 이룬다.
                        if (visited[posY][posX].get(direction))
                            break;
                        visited[posY][posX].set(direction);      
                        cycleLen++;
                        // 다음 경로의 위치 계산
                        posX = posX + x[direction];
                        posY = posY + y[direction];
                        // 동서남북 방향으로 grid를 넘어갔을 경우 위치 조정
                        if (posX < 0)
                            posX = cols - 1;
                        else if (posX >= cols)
                            posX = 0;
                        else if (posY < 0)
                            posY = rows - 1;
                        else if (posY >= rows)
                            posY = 0;
                        // 다음 경로의 위치에서 진행할 방향 계산
                        direction = findDirection(posY, posX, direction, grid);
                    }
                    answer.add(cycleLen);
                }
            }
        }
        
        // 오름차순 정렬
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 해당 위치에서 진행할 방향 결정
    public int findDirection(int row, int col, int dirFrom, String[] grid) {
        int dirTo = 0;
        switch(grid[row].charAt(col)) {
            case 'S' -> dirTo = dirFrom;
            case 'L' -> dirTo = dirFrom + 1;
            case 'R' -> dirTo = dirFrom + 3;
        } 
        return dirTo % 4;
    }
}