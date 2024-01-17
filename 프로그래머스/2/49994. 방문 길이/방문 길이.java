import java.util.*;

class Solution {
    List<Pair> visited = new ArrayList<>();
    
    public int solution(String dirs) {
        int answer = 0;
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        
        for (int i = 0; i < dirs.length(); i++) {            
            if (dirs.charAt(i) == 'U' && endY < 5)
                endY++;
            else if (dirs.charAt(i) == 'D' && endY > -5)
                endY--;
            else if (dirs.charAt(i) == 'R' && endX < 5)
                endX++;
            else if (dirs.charAt(i) == 'L' && endX > -5)
                endX--;
            else
                continue;
                        
            if (!isVisited(startX, startY, endX, endY)) {
                visited.add(new Pair(startX, startY, endX, endY));
                answer++;
            }
            startX = endX;
            startY = endY;
        }
        
        return answer;
    }
    
    private boolean isVisited(int startX, int startY, int endX, int endY) {
        for (Pair p : visited) {
            if (p.startX == startX && p.startY == startY && p.endX == endX && p.endY == endY)
                return true;
            else if (p.startX == endX && p.startY == endY && p.endX == startX && p.endY == startY)
                return true;
        }
        return false;
    }
}

class Pair {
    int startX;
    int startY;
    int endX;
    int endY;
    
    public Pair(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }
}