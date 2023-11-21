package baekjoon.b1747;

import java.util.Scanner;

public class Solution {

	public void solve() {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		if (n == 1 || (n != 2 && n % 2 == 0))
			n++;
		while (true) {
			if (isPalindrome(String.valueOf(n)) && isPrimeNum(n)) {
				System.out.println(n);
				break;
			}
			n += 2;
		}
	}

	private boolean isPalindrome(String num) {
		int l = 0;
		int r = num.length() - 1;

		while (l <= r) {
			if (num.charAt(l) == num.charAt(r)) {
				l++;
				r--;
			}
			else
				return false;
		}
		return true;
	}

	private boolean isPrimeNum(int num) {
		double max = Math.floor(Math.sqrt(num));
		for (long i = 2; i <= max; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

}
