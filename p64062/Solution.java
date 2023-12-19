package programmers.p64062;

import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        int l = 1;
        int r = 200000000;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (isPossible(mid, stones, k) == true) {
                answer = mid;
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return answer;
    }

    private boolean isPossible(int num, int[] stones, int k) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - num <= 0)
                count++;
            else
                count = 0;
            if (count == k)
                return true;
        }
        return false;
    }
}
