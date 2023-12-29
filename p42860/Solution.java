package programmers.p42860;

import java.util.*;
class Solution {
    public int solution(String name) {
        String dict = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int answer = 0;
        int move = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(dict.indexOf(name.charAt(i)) - dict.indexOf('A'), dict.indexOf('Z') - dict.indexOf(name.charAt(i)) + 1);
            int pos = i + 1 + countA(i+1, name);
            move = Math.min(move, i * 2 + name.length() - pos);
            move = Math.min(move, (name.length() - pos) * 2 + i);
        }
        return answer + move;
    }

    private int countA(int start, String name) {
        int count = 0;
        for (int i = start; i < name.length(); i++) {
            if (name.charAt(i) == 'A')
                count++;
            else
                break;
        }
        return count;
    }
}





