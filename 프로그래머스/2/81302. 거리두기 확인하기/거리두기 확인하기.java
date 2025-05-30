import java.util.*;

class Solution {
    int INFINITY = 10;
    int[] vertical = new int[]{0, 1, 0, -1};
    int[] horizontal = new int[]{1, 0, -1, 0};
    Deque<int[]> q = new ArrayDeque<>();
    BitSet visited = new BitSet(25);
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        
        for (int row = 0; row < places.length; row++) {
            for (int col = 0; col < places[row].length; col++) {
                for (int k = 0; k < places[row][col].length(); k++) {
                    if (places[row][col].charAt(k) == 'P') {
                        q.offerLast(new int[]{col, k, 0});
                        visited.set(col * 5 + k);

                        if (!bfs(places[row]))
                            answer[row] = 0;
                        visited.clear();
                        q.clear();
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean bfs(String[] place) {
        while (!q.isEmpty()) {
            int[] e = q.pollFirst();
            int row = e[0];
            int col = e[1];
            int dist = e[2];            
            
            if (dist > 0 && dist <= 2) {
                if (place[row].charAt(col) == 'P')
                    return false;                    
                else if (place[row].charAt(col) == 'X')
                    continue;
            }
            
            if (dist > 2)
                break;
            
            for (int i = 0; i < 4; i++) {
                int posX = col + horizontal[i];
                int posY = row + vertical[i];
                
                if (posX >= 0 && posX < 5 && posY >= 0 && posY < 5 && !visited.get(posX + posY * 5)) {                    
                    q.offerLast(new int[]{posY, posX, dist+1});
                    visited.set(posX + posY * 5);
                }
            }
        }
        
        return true;
    }
}