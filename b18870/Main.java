package baekjoon.b18870;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] origin = new int[n];
        for (int i = 0; i < n; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        int[] arr = Arrays.stream(origin).distinct().toArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = arr.length - 1;
            int mid = 0;
            while (l < r) {
                mid = (l + r + 1) / 2;
                if (arr[mid] > origin[i])
                    r = mid - 1;
                else
                    l = mid;
            }
            sb.append(l);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}