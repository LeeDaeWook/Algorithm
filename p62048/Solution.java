package programmers.p62048;

import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        long origin = (long)w * (long)h;
        long gcd = getGcd(Math.max(w, h), Math.min(w, h));

        return origin - (w / gcd + h / gcd - 1) * gcd;
    }

    private long getGcd(long a, long b) {
        if (a % b == 0)
            return b;

        long r = a % b;
        long rPrime = b % r;
        while (rPrime != 0) {
            long temp = rPrime;
            rPrime = r % rPrime;
            r = temp;
        }

        return r;
    }
}
