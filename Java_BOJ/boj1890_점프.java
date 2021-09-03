package today2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1890_점프 {

	static long[][] board;
	static int N;
	static long cnt;
	static long[][] dp;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		board = new long[N][N];
		dp = new long[N][N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		dp[0][0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == N - 1 && j == N - 1)
					continue;
				if (i + board[i][j] < N)
					dp[(int) (i + board[i][j])][j] += dp[i][j];
				if (j + board[i][j] < N)
					dp[i][(int) (j + board[i][j])] += dp[i][j];
			}
		}

		System.out.println(dp[N - 1][N - 1]);

	}

}

// 실패 - 시간초과 백트래킹
//public class boj1890_점프 {
//
//	static int[][] board;
//	static int N;
//	static int cnt;
//
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		N = Integer.parseInt(br.readLine());
//		cnt = 0;
//		board = new int[N][N];
//
//		for (int i = 0; i < N; i++) {
//			String[] temp = br.readLine().split(" ");
//			for (int j = 0; j < N; j++) {
//				board[i][j] = Integer.parseInt(temp[j]);
//			}
//		}
//		dfs(0,0);
//		System.out.println(cnt);
//
//	}
//
//	public static void dfs(int x, int y) {
//
//		if (x == N - 1 && y == N - 1) {
//			cnt++;
//			return;
//		}
//		if (x + board[x][y] < N)
//			dfs(x + board[x][y], y);
//		if (y + board[x][y] < N)
//			dfs(x, y + board[x][y]);
//	}
//
//}
