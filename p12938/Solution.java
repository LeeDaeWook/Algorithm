package programmers.p12938;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        int[] arr = IntStream.rangeClosed(1, n).toArray();
        int l = 0;
        int r = 0;
        int sum = 0;
        int product = 0;
        int temp;
        List<Integer> list = new ArrayList<>();
        list.stream().mapToInt(i -> i).toArray();
        while (true) {
            if (sum < s) {
                sum += arr[r++];
            }
            else {
                sum -= arr[l++];
            }

            if (sum == s && r - l == n) {
                temp = calculateProduct(arr, l, r);
                if (product < temp) {
                    product = temp;
                    for (int i = l; i < r; i++) {
                        answer[]
                    }
                }
            }
        }

        return answer;
    }

    private int calculateProduct(int[] arr, int l, int r) {
        int result = 1;

        for (int i = l; i < r; i++) {
            result *= arr[i];
        }
        return result;
    }
}

// 1 2 3 4 5 6 7 8




