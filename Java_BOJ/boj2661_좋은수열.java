package today4;

import java.util.Scanner;

public class boj2661_좋은수열 {

	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		back("");

	}

	public static void back(String s) {
		if (s.length() == N) {
			System.out.println(s);
			System.exit(0);
		}
		for (int i = 1; i <= 3; i++) {
			if (check(s + i)) {
				back(s + i);
			}
		}
	}

	public static boolean check(String s) {
		for (int i = 1; i <= s.length() / 2; i++) {
			if (s.substring(s.length() - i - i, s.length() - i).equals(s.substring(s.length() - i, s.length()))) {
				return false;
			}
		}
		return true;
	}
}
