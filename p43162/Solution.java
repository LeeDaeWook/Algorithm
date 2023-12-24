package programmers.p43162;

import java.util.*;
class Solution {
    int[] parent;

    public int solution(int n, int[][] computers) {
        int answer = 0;

        parent = new int[n + 1];
        fill(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    union(i+1, j+1, n, computers);
                }
            }
        }
        return (int) Arrays.stream(parent).distinct().count() - 1;
    }

    private void fill(int n) {
        for (int i = 1; i <= n; i++)
            parent[i] = i;
    }

    private boolean find(int x, int y) {
        return getParent(x) == getParent(y);
    }

    private void union(int x, int y, int n, int[][] computers) {
        int a = getParent(x);
        int b = getParent(y);
        if (a < b) {
            parent[b] = a;
            unionRelatives(b, n, computers);
        }
        else {
            parent[a] = b;
            unionRelatives(a, n, computers);
        }
    }

    private void unionRelatives(int x, int n, int[][] computers) {
        for (int i = 1; i <= n; i++) {
            if (computers[x-1][i-1] == 1 && !find(x, i))
                union(i, x, n, computers);
        }
    }

    private int getParent(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = getParent(parent[x]);
    }
}
