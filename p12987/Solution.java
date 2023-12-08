package programmers.p12987;

import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int save = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = save; j < A.length; j++) {
                if (B[j] > A[i]) {
                    save = j + 1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
