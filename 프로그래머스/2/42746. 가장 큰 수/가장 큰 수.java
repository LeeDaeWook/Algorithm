import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        int len = numbers.length;
        String[] strNums = new String[len];

        for (int i = 0; i < len; i++)
            strNums[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(strNums, (a, b) -> (b+a).compareTo(a+b));
        
        if (strNums[0].equals("0"))
            return "0";
        
        for (int i = 0; i < len; i++) {
            answer.append(strNums[i]);
        }
        
        return answer.toString();
    }    
}