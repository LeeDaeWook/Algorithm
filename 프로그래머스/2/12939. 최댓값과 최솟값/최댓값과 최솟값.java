import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        String arr[] = s.split(" ");
        int max = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[0]);
        
        for (String cut : arr) {
            int num = Integer.parseInt(cut);
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        
        String answer = Integer.toString(min) + " "+ Integer.toString(max);
        
        return answer;
    }
}