package today;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj14501 {
	static int N;
	static int result1;
	static int result2;
	static int[][] board;
	static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][2];
		check = new boolean[N];

		for (int i = 0; i < N; i++) {

			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			if (i + 1 + num1 <= N + 1) {
				board[i][0] = num1;
				board[i][1] = num2;
			}

		}

		dfs(0, 0);
		System.out.println(result2);

	}

	public static void dfs(int start, int cnt) {
		result1 = 0;
		if (cnt > N) {
			return;
		}

		for (int i = 0; i < check.length; i++) {
			if (check[i]) {
				result1 += board[i][1];
			}
		}

		if (cnt <= N) {
			result2 = Math.max(result2, result1);
		}

		for (int i = start; i < check.length; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(i + board[i][0], cnt + board[i][0]);
				result1 = 0;
				check[i] = false;

			}
		}
	}
}
