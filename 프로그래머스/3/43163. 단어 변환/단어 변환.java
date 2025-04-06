class Solution {
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        int len = words.length;
        boolean[] visited = new boolean[len];
        
        dfs(begin, target, words, 0, visited, len);
        
        return answer;
    }
    
    public void dfs(String word, String target, String[] words, int depth, boolean[] visited, int len) {    
        for (int i = 0; i < len; i++) {
            // 현재 단어가 target과 같은지 확인
            if (word.equals(target)) {     
                // 한번이라도 변환 가능한 값을 찾았다면 현재 답과 새로운 답 중에서 작은 값 선택                
                if (answer > 0)
                    answer = Math.min(answer, depth);
                else
                    answer = depth;
                return ;
            }
            
            // 변환했던 단어가 아니고, 현재 단어와 한 글자만 다르면 한 depth 더 들어가서 로직 수행
            if (!visited[i] && isOneLetterDiff(word, words[i])) {
                // 방문한 단어 체크
                visited[i] = true;

                dfs(words[i], target, words, depth+1, visited, len);
                
                boolean[] newVisited = new boolean[len];
                System.arraycopy(visited, 0, newVisited, 0, len);
                visited = newVisited;
            }         
        }
    }
    
    public boolean isOneLetterDiff(String s1, String s2) {
        int len = s1.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        }
        
        return count == 1;
    }
}