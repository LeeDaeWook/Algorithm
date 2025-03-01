import java.util.*;

class Solution {
    char[] s = "0123456789ABCDEF".toCharArray();
    
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        Deque<Character> nums = new ArrayDeque<>();
        
        for (int i = t*m - 1; i >= 0; i--) {
            int num = i;
            while (num > 0) {
                nums.addFirst(s[num%n]);
                num /= n;
            }
        }    
        nums.addFirst('0');
                
        Character[] numsArray = nums.stream().map(Character::charValue).toArray(Character[]::new);
        
        for (int i = 0; answer.length() < t; i += m)
            answer.append(numsArray[p-1 + i]);
        
        return answer.toString();
    }    
}
