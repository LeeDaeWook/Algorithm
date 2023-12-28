package programmers.p154538;

import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(0, y));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (p.num == x) {
                return p.count;
            }
            if (p.num > x) {
                if (p.num % 3 == 0)
                    q.add(new Pair(p.count + 1, p.num / 3));
                if (p.num % 2 == 0)
                    q.add(new Pair(p.count + 1, p.num / 2));
                q.add(new Pair(p.count + 1, p.num - n));
            }
        }

        return answer;
    }
}

class Pair {
    int count;
    int num;

    public Pair(int count, int num) {
        this.count = count;
        this.num = num;
    }
}
