package today;

import java.util.Scanner;

public class boj14889 {

	static int N;
	static int result1;
	static int result2;
	static int[][] board;
	static boolean[] check;
	static int[] team1;
	static int[] team2;
	static int boardsum;
	static int min;
	static int num1;
	static int num2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N][N];
		check = new boolean[N];
		team1 = new int[N];
		team2 = new int[N];
		boardsum = 0;
		result1 = 0;
		result2 = 0;
		num1 = 0;
		num2 = 0;
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = sc.nextInt();
				boardsum += board[i][j];
			}
		}
		dfs(0, 0);
		System.out.println(min);
	}

	public static void dfs(int start, int cnt) {
		if (cnt == N / 2) {

			for (int i = 0; i < check.length; i++) {
				if (check[i]) {
					team1[num1++] = i;
				} else {
					team2[num2++] = i;
				}
			}

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < N / 2; j++) {
					result1 += board[team1[i]][team1[j]];
					result2 += board[team2[i]][team2[j]];
				}
			}
			min = Integer.min(min, Math.abs(result1 - result2));

			result1 = 0;
			result2 = 0;
			cnt = 0;
			num1 = 0;
			num2 = 0;
			return;
		}
		for (int i = start; i < N; i++) {
			if (!check[i]) {
				check[i] = true;
				dfs(i + 1, cnt + 1);
				check[i] = false;
			}
		}
	}

}
