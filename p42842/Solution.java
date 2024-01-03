package programmers.p42842;

import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int total = brown + yellow;

        for (int height = 1; ; height++) {
            int width = total / height;
            if (height * width == total) {
                if (isTrue(height, width, yellow)) {
                    answer[0] = width;
                    answer[1] = height;
                    return answer;
                }
            }
        }
    }

    private boolean isTrue(int height, int width, int yellow) {
        return (width - 2) * (height - 2) == yellow;
    }
}
