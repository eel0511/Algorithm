package today4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj14391_종이조각 {

	static int N, M, total;
	static int[][] board;
	static boolean[] check;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		total = 0;
		board = new int[N][M];
		check = new boolean[N * M];
		for (int i = 0; i < board.length; i++) {
			temp = br.readLine().split("");
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		dfs(0);
		System.out.println(total);

	}

	public static void dfs(int index) {
		if (index == N * M) {
			sum();
			return;
		}
		check[index] = true;
		dfs(index + 1);
		check[index] = false;
		dfs(index + 1);
	}

	public static void sum() {
		int sum = 0, save = 0;

		// 가로
		for (int i = 0; i < N; i++) {
			save = 0;
			for (int j = 0; j < M; j++) {
				if (check[i * M + j]) {
					save *= 10;
					save += board[i][j];
				} else {
					sum += save;
					save = 0;
				}
			}
			sum += save;
		}

		// 세로
		for (int j = 0; j < M; j++) {
			save = 0;
			for (int i = 0; i < N; i++) {
				if (!check[i * M + j]) {
					save *= 10;
					save += board[i][j];
				} else {
					sum += save;
					save = 0;
				}
			}
			sum += save;
		}
		total = Integer.max(total, sum);
	}

}
