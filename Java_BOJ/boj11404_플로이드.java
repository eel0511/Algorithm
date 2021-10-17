package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj11404_플로이드 {

	static int N, M;
	static int[][] board;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int INF = 10000001;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];

		for (int i = 0; i < N + 1; i++) {
			Arrays.fill(board[i], INF);
			board[i][i] = 0;
		}
		for (int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int cost = Integer.parseInt(s[2]);
			if (board[start][end] > cost) {
				board[start][end] = cost;
			}
		}

		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {

					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}

				}
			}
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (board[i][j] != INF) {
					System.out.print(board[i][j] + " ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
}
