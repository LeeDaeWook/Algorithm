import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder(s.toLowerCase());
        for (int i = 0; i < answer.length(); i++) {
            if (i+1 < answer.length() && answer.charAt(i) == ' ' && Character.isAlphabetic(answer.charAt(i+1))) {
                answer.insert(i+1, Character.toUpperCase(answer.charAt(i+1)));
                answer.deleteCharAt(i+2);
            }
            else if (i == 0 && Character.isAlphabetic(answer.charAt(i))) {
                answer.insert(i, Character.toUpperCase(answer.charAt(i)));
                answer.deleteCharAt(i+1);
            }
        } 
        return answer.toString();
    }
}