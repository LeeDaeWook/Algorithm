import java.lang.*;

class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        int q = n, r;
        while (q > 0) {
            r = q % 3;
            q = q / 3;
            if (r == 0) {
                answer.append("4");
                q--;   
            }
            else
                answer.append(String.valueOf(r));
        }
        
        answer.reverse();
        return answer.toString();
    }
}