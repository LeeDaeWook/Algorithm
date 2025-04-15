import java.util.*;

class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    Deque<int[]> q = new ArrayDeque<>();
    boolean[][] removed;
    boolean[][] isOutside;
    int rowLen;
    int colLen;
    int removedContainers = 0;
    
    public int solution(String[] storage, String[] requests) {
        rowLen = storage.length;
        colLen = storage[0].length();
        
        removed = new boolean[rowLen][colLen];
        isOutside = new boolean[rowLen][colLen];
        
        // isOutside 초기화
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (i == 0 || j == 0 || i == rowLen - 1 || j == colLen - 1)
                    isOutside[i][j] = true;
            }
        }
        
        for (String request: requests) {
            if (request.length() == 1)
                forklift(storage, request.charAt(0));
            else
                crane(storage,  request.charAt(0));
            checkIsOutside(storage);
        }
                
        return rowLen * colLen - removedContainers;
    }
    
    public void checkIsOutside(String[] storage) {
        while (!q.isEmpty()) {
            int[] pos = q.pollFirst();
            for (int i = 0; i < 4; i++) {
                if (pos[0]+dy[i] >= 0 && pos[1]+dx[i] >= 0 && pos[0]+dy[i] < rowLen && pos[1]+dx[i] < colLen) {
                    if (removed[pos[0]+dy[i]][pos[1]+dx[i]] && !isOutside[pos[0]+dy[i]][pos[1]+dx[i]])
                        q.offerLast(new int[]{pos[0]+dy[i], pos[1]+dx[i]});
                    isOutside[pos[0]+dy[i]][pos[1]+dx[i]] = true;    
                }
            }
        }
    }
    
    public void forklift(String[] storage, char container) {
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (storage[i].charAt(j) != container || removed[i][j])
                    continue;
                if (isOutside[i][j]) {                    
                    removed[i][j] = true;      
                    removedContainers++;
                    q.offerLast(new int[]{i, j});
                }
            }
        }
    }
    
    public void crane(String[] storage, char container) {
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (storage[i].charAt(j) != container || removed[i][j])
                    continue;                
                removed[i][j] = true;
                removedContainers++;
                if (isOutside[i][j])
                    q.offerLast(new int[]{i, j});
            }
        }
    }
}