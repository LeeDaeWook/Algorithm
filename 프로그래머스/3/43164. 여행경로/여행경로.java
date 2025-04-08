import java.util.*;

class Solution {
    String[] answer = null;
    
    public String[] solution(String[][] tickets) {
        int len = tickets.length;
        boolean[] used = new boolean[len];
        String[] visited = new String[len+1];
        
        visited[0] = "ICN";
        dfs(used, tickets, "ICN", visited, 1, len);
            
        return answer;
    }
    
    public void dfs(boolean[] used, String[][] tickets, String curAirport, String[] visited, int curDestinationIdx, int ticketLen) {       
        for (int i = 0; i < ticketLen; i++) {
            if (!used[i] && curAirport.equals(tickets[i][0])) {
                // 사용한 티켓 체크
                used[i] = true;
                if (visited[curDestinationIdx-1].equals(tickets[i][1]))
                    continue;
                
                // 이번 도착 공항 visited에 삽입                
                visited[curDestinationIdx] = tickets[i][1];
                dfs(used, tickets, tickets[i][1], visited, curDestinationIdx+1, ticketLen);
                used[i] = false;
            }
        }
        
        if (isDone(used, tickets)) {
            if (answer == null)
                answer = Arrays.copyOf(visited, getRealLength(visited));
            else
                answer = compare(answer, visited, getRealLength(visited));
            return ;
        }
    }
    
    public boolean isDone(boolean[] used, String[][] tickets) {
        int len = tickets.length;
        Set<String> dept = new HashSet<>();
        Set<String> dest = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                dept.add(tickets[i][0]);
                dest.add(tickets[i][1]);
            }
        }
        
        return (dept.size() == 0 && dest.size() == 0) || (dept.size() == 1 && dest.size() == 1);
    }
    
    public String[] compare(String[] s1, String[] s2, int len) {            
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                if (s1[i].charAt(j) > s2[i].charAt(j))
                    return Arrays.copyOf(s2, len);
                else if (s1[i].charAt(j) < s2[i].charAt(j))
                    return s1;
            }
        }
        return s1;
    }
    
    public int getRealLength(String[] s) {
        int len = s.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s[i] == null)
                break;
            count++;
        }
        
        return count;
    }
}