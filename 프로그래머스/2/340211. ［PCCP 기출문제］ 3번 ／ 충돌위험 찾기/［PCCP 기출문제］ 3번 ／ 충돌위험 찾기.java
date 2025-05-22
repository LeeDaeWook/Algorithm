import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<BitSet> passed = new ArrayList<>();
        List<BitSet> isCollide = new ArrayList<>();
              
        // 모든 로봇 순회
        for (int i = 0; i < routes.length; i++) {
            // 시점 초기화
            int time = 0;
            
            // 각 로봇의 경로 순회
            for (int j = 0; j < routes[i].length-1; j++) {
                // 현재 경로에서의 출발지점과 도착지점 계산
                int p1 = routes[i][j];
                int p2 = routes[i][j+1];
                
                // 출발지점의 행과 도착지점의 행 계산
                int rowStart = points[p1-1][0]-1;
                int rowEnd = points[p2-1][0]-1;
                
                // 출발지점의 열과 도착지점의 열 계산
                int colStart = points[p1-1][1]-1;
                int colEnd = points[p2-1][1]-1;
                
                // 출발지점에서 도착지점으로 행 이동할 때, 증가 이동인지 감소이동인지 판단
                int step = rowStart - rowEnd < 0 ? 1 : -1;
                
                // 각 시점에서의 로봇이 행 이동할때의 좌표 계산
                for (int row = j == 0 ? rowStart : rowStart+step; row != rowEnd + step; row += step) {
                    // 현재 시점이 처음인 경우 passed에 BitSet 추가
                    if (passed.size() < ++time) {
                        passed.add(new BitSet(10000));  
                        isCollide.add(new BitSet(10000));                        
                    }
                    // 현재 시점에서 (row, colStart) 좌표를 지나갔던 로봇이 있는 경우 isCollide의 (row, colStart)비트를 1로 변경
                    if (passed.get(time-1).get(row * 100 + colStart))
                        isCollide.get(time-1).set(row * 100 + colStart);
                    else
                        passed.get(time-1).set(row * 100 + colStart);                    
                }
                
                // 출발지점에서 도착지점으로 열 이동할 때, 증가 이동인지 감소이동인지 판단
                step = colStart - colEnd < 0 ? 1 : -1;
                
                // 각 시점에서의 로봇이 열 이동할때의 좌표 계산
                for (int col = colStart+step; col != colEnd + step; col += step) {
                    if (passed.size() < ++time) {
                        passed.add(new BitSet(10000));
                        isCollide.add(new BitSet(10000));                        
                    }
                    if (passed.get(time-1).get(rowEnd * 100 + col))
                        isCollide.get(time-1).set(rowEnd * 100 + col);
                    else
                        passed.get(time-1).set(rowEnd * 100 + col);                    
                }                
            }
        }
        
        for (BitSet b: isCollide)
            answer += b.cardinality();
        
        return answer;
    }
}