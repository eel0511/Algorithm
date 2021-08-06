package today;

import java.util.Scanner;

public class boj2606_바이러스 {

	static int N;
	static int M;
	static int[][] board;
	static boolean[] check;
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N + 1][N + 1];
		check = new boolean[N + 1];
		cnt = 0;
		for (int i = 0; i < M; i++) {

			board[sc.nextInt()][sc.nextInt()] = 1;

		}
		dfs(1);
		System.out.println(cnt);

	}

	public static void dfs(int start) {
		check[start] = true;

		for (int i = 0; i < N + 1; i++) {
			if (!check[i] && (board[start][i] == 1 || board[i][start] == 1)) {
				check[i] = true;
				dfs(i);
				cnt++;
			}
		}
	}

}
