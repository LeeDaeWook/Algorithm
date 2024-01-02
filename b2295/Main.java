package baekjoon.b2295;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] one = new int[n];
        for (int i = 0; i < n; i++) {
            one[i] = sc.nextInt();
        }

        Arrays.sort(one);

        int sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        int[] two = new int[sum];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                two[idx++] = one[i] + one[j];
            }
        }
//        two = Arrays.stream(two).distinct().toArray();

        Arrays.sort(two);
        System.out.println(two.length);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int l = 0;
                int r = two.length - 1;
                // 이분탐색
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (two[mid] > one[i] - one[j])
                        r = mid - 1;
                    else if (two[mid] < one[i] - one[j])
                        l = mid + 1;
                    else {
                        answer = Math.max(answer, one[i]);
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

