package today;

import java.util.Scanner;

public class boj1012_유기농배추 {

	static int T;
	static int M;
	static int N;
	static int K;
	static int[][] board;
	static boolean[][] check;
	static int cnt;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();
		for (int t = 0; t < T; t++) {

			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			cnt = 0;
			board = new int[M + 1][N + 1];
			check = new boolean[M + 1][N + 1];
			for (int i = 0; i < K; i++) {
				board[sc.nextInt()][sc.nextInt()] = 1;
			}

			int temp = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 1 && !check[i][j]) {
						dfs(i, j);
						cnt++;
					}

				}
			}

			System.out.println(cnt);
		}

	}

	public static void dfs(int x, int y) {
		check[x][y] = true;

		int[] dx = { 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < dy.length; i++) {

			int newx = x + dx[i];
			int newy = y + dy[i];

			if (isNotWall(newx, newy) && !check[newx][newy] && board[newx][newy] == 1) {
				dfs(newx, newy);
			}

		}

	}

	public static boolean isNotWall(int x, int y) {

		if (x >= 0 && x < M && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

}
