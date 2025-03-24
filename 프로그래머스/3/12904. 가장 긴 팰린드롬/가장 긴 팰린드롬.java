import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            if (len - i <= answer)
                break;
            for (int j = len-1; j > i; j--) {
                int subStringLen = j+1-i;
                if (subStringLen <= answer)
                    break;
                if (isPalindrome(s, i, j, (subStringLen) / 2))
                    answer = subStringLen;
            }
        }

        return answer;
    }
    
    public boolean isPalindrome(String s, int start, int end, int len) {
        for (int i = 0; i < len; i++) {
            if (s.charAt(start+i) != s.charAt(end-i))
                return false;
        }
        return true;
    }
}