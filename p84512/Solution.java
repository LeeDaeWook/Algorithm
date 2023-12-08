package programmers.p84512;

import java.util.*;
class Solution {
    public int solution(String word) {
        int[] answer = new int[1];

        String[] dict = new String[]{"A", "E", "I", "O", "U"};
        int[] depth = new int[1];

        dfs(answer, depth, dict, word, "");

        return answer[0];
    }

    private void dfs(int[] answer, int[] depth, String[] dict, String inputWord, String makeWord) {
        if (inputWord.equals(makeWord)) {
            answer[0] = depth[0];
            return ;
        }

        if (makeWord.length() == 5) {
            return ;
        }

        for (int i = 0; i < 5; i++) {
            (depth[0])++;
            dfs(answer, depth, dict, inputWord, makeWord + dict[i]);
        }
    }
}