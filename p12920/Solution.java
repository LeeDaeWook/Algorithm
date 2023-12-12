package programmers.p12920;

import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        int l = 0;
        int r = 10000 * n;
        int mid;
        int temp;
        int work = 0;
        int time = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            temp = calculateProcessedWorks(mid, cores);
            if (n > temp)
                l = mid + 1;
            else {
                r = mid - 1;
                work = temp;
                time = mid;
            }
        }

        work -= n;
        for (int i = cores.length - 1; i >= 0; i--) {
            if (time % cores[i] == 0) {
                if (work == 0)
                    return i + 1;
                work--;
            }
        }

        return answer;
    }

    private int calculateProcessedWorks(int time, int[] cores) {
        int result = 0;

        for (int t : cores) {
            result += time / t + 1;
        }
        return result;
    }
}
