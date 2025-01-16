import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        String c;
        Deque<String> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            c = String.valueOf(s.charAt(i));
            if (stack.size() == 0) 
                stack.push(c);
            else {
                if (c.equals(stack.peekFirst()))                  
                    stack.pop();
                else
                    stack.push(c);
            }  
        }
        
        if (stack.size() == 0)
            answer = 1;
        else
            answer = 0;
        
        return answer;
    }
}