package programmers.p86053;

import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0L;

        long l = 0L;
        long r = 1000000000L * 2L * 100000L * 2L;
        long mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (isPossible(mid, a, b, g, s, w, t)) {
                answer = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return answer;
    }

    private boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long total = 0L;
        long totalGold = 0L;
        long totalSilver = 0L;

        long count;
        long totalAmountPerCity;
        for (int i = 0; i < g.length; i++) {
            count = time / (2L * t[i]);
            if (time % (2L * t[i]) >= t[i])
                count++;

            totalAmountPerCity = Math.min(count * w[i], g[i] + s[i]);
            total += totalAmountPerCity;
            totalGold += Math.min(totalAmountPerCity, g[i]);
            totalSilver += Math.min(totalAmountPerCity, s[i]);
        }
        if (total >= a + b && totalGold >= a && totalSilver >= b)
            return true;
        return false;
    }
}

