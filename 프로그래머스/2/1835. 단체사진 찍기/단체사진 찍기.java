import java.lang.Math.*;
import java.util.*;

class Solution {
    String members = "ACFJMNRT";
    boolean[] used = new boolean[8];
    int[] index = new int[8];
    int answer = 0;
    
    public int solution(int n, String[] data) {        
        dfs(0, n, data);
        
        return answer;
    }
    
    public void dfs(int depth, int n, String[] data) {
        // 조건 확인
        if (!isMeet(n, data))
            return;
        
        if (depth == 8) {
            answer++;
            return;            
        }
        
        // 재귀
        for (int i = 0; i < 8; i++) {
            if (used[i])
                continue;
            used[i] = true;
            index[i] = depth;
            dfs(depth+1, n, data);
            used[i] = false;
        }
    }
    
    public boolean isMeet(int n, String[] data) {
        for (int i = 0; i < n; i++) {
            int m1 = members.indexOf(data[i].charAt(0));
            int m2 = members.indexOf(data[i].charAt(2));
            if (used[m1] && used[m2]) {
                int condition = data[i].charAt(4) - '0';
                int interval = Math.abs(index[m1] - index[m2]) - 1;
                switch(data[i].charAt(3)) {
                    case '=' -> {
                        if (interval != condition)
                            return false;
                    }
                    case '<' -> {
                        if (interval >= condition)
                            return false;
                    }
                    case '>' -> {
                        if (interval <= condition)
                            return false;
                    }
                }
            }
        }
        
        return true;
    }
}