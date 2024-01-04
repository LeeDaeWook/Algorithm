package programmers.p70129;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int num = s.replace("0", "").length();
            answer[1] += s.length() - num;
            s = Integer.toBinaryString(num);
            (answer[0])++;
        }

        return answer;
    }
}
