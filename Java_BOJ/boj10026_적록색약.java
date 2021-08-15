package today;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10026_적록색약 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static String[][] board;
	static String[][] RGboard;
	static boolean[][] check;
	static int N, result;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new String[N][N];
		RGboard = new String[N][N];
		check = new boolean[N][N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				board[i][j] = st[j];
				RGboard[i][j] = st[j];
				if (st[j].equals("R")) {
					RGboard[i][j] = "G";
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (!check[i][j]) {

					dfs(board, i, j, board[i][j]);

					result++;

				}
			}
		}
		System.out.print(result + " ");
		init();
		result = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (!check[i][j]) {

					dfs(RGboard, i, j, RGboard[i][j]);

					result++;

				}
			}
		}
		System.out.println(result);

	}

	public static void dfs(String[][] board, int x, int y, String color) {

		check[x][y] = true;

		for (int i = 0; i < dx.length; i++) {
			int newx = x + dx[i];
			int newy = y + dy[i];
			if (isNotWall(newx, newy) && board[newx][newy].equals(color) && !check[newx][newy]) {
				check[newx][newy] = true;
				dfs(board, newx, newy, color);
			}
		}

	}

	public static boolean isNotWall(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < N) {
			return true;
		}
		return false;
	}

	public static void init() {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length; j++) {
				check[i][j] = false;
			}
		}
	}
}
