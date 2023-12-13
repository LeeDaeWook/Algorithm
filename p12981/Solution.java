package programmers.p12981;

import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        String end;
        List<String> previousWords = new ArrayList<>();
        for (int i = 1; i < words.length; i++) {
            previousWords.add(words[i - 1]);
            if (!words[i - 1].endsWith(String.valueOf(words[i].charAt(0))) || previousWords.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }
}
