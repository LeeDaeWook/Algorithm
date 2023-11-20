package baekjoon_3273;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public void solve() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] series = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			series[i] = Integer.parseInt(st.nextToken());
		}
		int x = Integer.parseInt(br.readLine());

		Arrays.sort(series);
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		bw.write(bruteForce(series, n, x));
//		bw.newLine();
//		bw.flush();
//		bw.close();
		System.out.println(bruteForce(series, n, x));
	}

	private int bruteForce(int[] series, int n, int x) {
		int result = 0;

		for (int i = 0; i < n; i++) {
			if (series[i] >= x)
				break;
			for (int j = i + 1; j < n; j++) {
				if (series[i] + series[j] == x)
					result++;
				if (series[j] >= x)
					break;
			}
		}
		return result;
	}

}
